import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;

public class errorCheck extends BaseErrorListener {
    public static errorCheck errorCheck = new errorCheck();
    ArrayList<String> errors;

    public errorCheck() {
        this.errors = new ArrayList<>();
    }
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        errors.add("Error on line "+line+", character "+(charPositionInLine)+ ": " + msg + "\n");
        super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
    }
}
