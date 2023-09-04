import SVMPkg.SVMLexer;
import SVMPkg.SVMParser;
import ast.Node;
import interpreter.ExecuteVM;
import org.antlr.v4.runtime.*;
import sem_an.Environment;
import sem_an.simpLanPlusError;
import sem_an.SemanticError;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        String inputPath = "./src/input.txt";
        boolean skipTypeCheck = true;

        String input = new String(Files.readAllBytes(Paths.get(inputPath)));
        CharStream stream = CharStreams.fromString(input);
        SimpLanPlusLexer lexer = new SimpLanPlusLexer(stream);

        errorCheck errorCheck = new errorCheck();
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorCheck);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        System.out.println("Lexical/syntactic analysis start.");
        try {
            SimpLanPlusParser parser;

            parser = new SimpLanPlusParser(tokens);

            parser.removeErrorListeners();
            parser.addErrorListener(errorCheck);

            Visitor visitor = new Visitor();

            Node ast = visitor.visit(parser.prog());

            File f = new File("./out/errors.txt");
            if (f.exists()) {
                f.delete();
            }
            if (!errorCheck.errors.isEmpty()) {
            f.createNewFile();
            for (String s : errorCheck.errors) {
                System.out.println(s);
                Files.write(Paths.get("./out/errors.txt"), s.getBytes(), StandardOpenOption.APPEND);
            }
            throw new simpLanPlusError("Errors found. Find the output in ./out/errors.txt");
            }
            System.out.println("Lexical/syntactic analysis completed.");


            System.out.println("Semantic analysis start.");
            Environment env = new Environment();
            ArrayList<SemanticError> err = ast.checkSemantics(env);
            if (!err.isEmpty()) {
                System.out.println("SEMANTIC ERRORS");
                for (SemanticError er : err)
                    System.out.println(er);
                throw new simpLanPlusError("Semantic errors found.");
            }
            System.out.println("Semantic analysis completed.");


            if (skipTypeCheck) {
                System.out.println("TypeChecking skipped.");
            } else {
                System.out.println("TypeChecking started.");
                ast.typeCheck(env);
                System.out.println("TypeChecking completed.");
            }

            System.out.println("Code generation started.");
            String code = ast.codeGeneration(env);

            File f2 = new File("./out/code.asm");

            if (f2.exists()) {
                f2.delete();
            }
            f2.createNewFile();

            Files.write(Paths.get("./out/code.asm"), code.getBytes(), StandardOpenOption.WRITE);

            System.out.println("Code successfully generated. Find the output in /out/code.asm");


            String fileName = "./out/code.asm";

            CharStream inputASM = CharStreams.fromFileName(fileName);

            SVMLexer lexerASM = new SVMLexer(inputASM);
            CommonTokenStream tokensASM = new CommonTokenStream(lexerASM);
            SVMParser parserASM = new SVMParser(tokensASM);

            SVMVisitorImpl visitorSVM = new SVMVisitorImpl();
            visitorSVM.visit(parserASM.assembly());

            System.out.println("Starting Virtual Machine...");
            ExecuteVM vm = new ExecuteVM(visitorSVM.code);
            vm.cpu();

        } catch (Exception e) {
            System.out.println("Exception in the analysis process.\n");
            throw new simpLanPlusError(e.getMessage());
        }
    }
}


