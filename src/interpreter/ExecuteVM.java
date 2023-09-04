package interpreter;

import SVMPkg.SVMParser;

import java.util.Hashtable;

public class ExecuteVM {
    
    public static final int CODESIZE = 1000 ;
    public static final int MEMSIZE =  1000 ; //10000;
 
    private AssemblyClass[] code;
    private int[] memory = new int[MEMSIZE];
    
    private int IP = 0;  			// instruction pointer
    private int SP = MEMSIZE-1 ;	// stack pointer
    private int AL = MEMSIZE-2 ; 	// access link
    private int FP = MEMSIZE-1 ; 	// frame pointer
    private int RA;           		// return address
    private int A0;					// the register for values of expressions
    private int T1;					// temporary register
    private int T2;					// additional temporary register, just in case
	Hashtable<Integer, String> parseString = new Hashtable<>();


	public void initializeParseString() {
		this.parseString.put(1,"T__0");
		this.parseString.put(2,"T__1");
		this.parseString.put(3,"T__2");
		this.parseString.put(4,"LOAD");
		this.parseString.put(5,"STORE");
		this.parseString.put(6,"STOREI");
		this.parseString.put(7,"MOVE");
		this.parseString.put(8,"ADD");
		this.parseString.put(9,"ADDI");
		this.parseString.put(10,"SUB");
		this.parseString.put(11,"SUBI");
		this.parseString.put(12,"MUL");
		this.parseString.put(13,"MULI");
		this.parseString.put(14,"DIV");
		this.parseString.put(15,"DIVI");
		this.parseString.put(16,"PUSH");
		this.parseString.put(17,"PUSHR");
		this.parseString.put(18,"POP");
		this.parseString.put(19,"POPR");
		this.parseString.put(20,"BRANCH");
		this.parseString.put(21,"BRANCHEQ");
		this.parseString.put(22,"BRANCHLESSEQ");
		this.parseString.put(23,"JUMPSUB");
		this.parseString.put(24,"RETURNSUB");
		this.parseString.put(25,"HALT");
		this.parseString.put(26,"BRANCHEGT");
		this.parseString.put(27,"BRANCHEQLT");
		this.parseString.put(28,"BRANCHEQGTE");
		this.parseString.put(29,"REG");
		this.parseString.put(30,"LABEL");
		this.parseString.put(31,"NUMBER");
		this.parseString.put(32,"WHITESP");
		this.parseString.put(33,"LINECOMENTS");
		this.parseString.put(34,"ERR");
	}
    public ExecuteVM(AssemblyClass[] _code) {
    		code = _code ;
			this.initializeParseString();
    }


	public String parseString(Integer key) {
		return this.parseString.get(key);
	}

    public void StampaMem(int num){
    		System.out.print(num + ": " + this.parseString(code[IP].getCode())) ;
    		for (int i = MEMSIZE-1; i > SP; i--){
    			System.out.print("\t" + memory[i]) ; 			
    		}
    		System.out.println("\t\t" + "| SP: " + SP + " | FP: " + FP + " | AL = " + AL + " | RA: " + RA + "| A0: " + A0 + " | T1: " + T1 + " |") ;
    }
  
    public int read(String var) {
    	int tmp ;
    	switch (var) {
    		case "IP":
    			tmp = IP;
    			break ;
    		case "SP":
    			tmp = SP;
    			break ;
    		case "AL":
    			tmp = AL;
    			break ;
    		case "FP":
    			tmp = FP;
    			break ;
    		case "RA":
    			tmp = RA;
    			break ;
    		case "A0":
    			tmp = A0;
    			break ;
    		case "T1":
    			tmp = T1;
    			break ;
    		case "T2":
    			tmp = T2;
    			break ;
    		default :
    			tmp = -99999 ; // error value
    			break ;
    	}
    	return tmp ;
    }
    
    public void update(String var, int val) {
    	switch (var) {
    		case "IP":
    			IP = val ;
    			break ;
    		case "SP":
    			SP = val ;
    			break ;
    		case "AL":
    			AL = val ;
    			break ;
    		case "FP":
    			FP = val ;
    			break ;
    		case "RA":
    			RA = val ;
    			break ;
    		case "A0":
    			A0 = val;
    			break ;
    		case "T1":
    			T1 = val ;
    			break ;
    		case "T2":
    			T2 = val ;
    			break ;
    		default :
    			 // error value
    			break ;
    	}
    }

     public void cpu() {    
    	int j = 0 ;
 
    	while ( true ) {
    	    StampaMem(j) ;
			j=j+1 ;

	   	  	AssemblyClass bytecode = code[IP] ; // fetch
            int tmp ;
            int address;
            switch ( bytecode.getCode() ) {
                case SVMParser.PUSH:
                   push(Integer.parseInt(bytecode.getArg1())) ;
                   IP = IP +1 ;
            	   break;
                case SVMParser.PUSHR:
                 	push(read(bytecode.getArg1()));
                	IP = IP +1 ;
                	break ;
                case SVMParser.POP:
            	  		pop();
            	  		IP = IP +1 ;
            	  		break;
                case SVMParser.LOAD:
                	tmp = read(bytecode.getArg3()) + Integer.parseInt(bytecode.getArg2()) ;	
                    if ((tmp < 0) || (tmp >= MEMSIZE)) {
                        System.out.println("\nError: Null pointer exception");
                        return;
                    } else {
                    	memory[tmp] = read(bytecode.getArg1()) ;
                    	IP = IP +1 ;
                    	break;
                    }
                case SVMParser.STOREI:
                    update(bytecode.getArg1(), Integer.parseInt(bytecode.getArg2())) ;
                      IP = IP +1 ;
                    break;
                case SVMParser.STORE:
                	tmp = read(bytecode.getArg3()) + Integer.parseInt(bytecode.getArg2()) ;	
                    if ((tmp < 0) || (tmp >= MEMSIZE)) {
                        System.out.println("\nError: Null pointer exception");
                        return;
                    } else {
                    	update(bytecode.getArg1(), memory[tmp]);            	
                    	IP = IP +1 ;
                    	break;
                    }
                case SVMParser.MOVE:
                    update(bytecode.getArg2(), read(bytecode.getArg1())) ;
                    IP = IP +1 ;
                    break;
                case SVMParser.ADD:
                    push(read(bytecode.getArg1()) + read(bytecode.getArg2())) ;
                    IP = IP +1 ;
            	  	break;
                case SVMParser.ADDI:
                	update(bytecode.getArg1(), read(bytecode.getArg1()) + Integer.parseInt(bytecode.getArg2()) );
                    IP = IP +1 ;
            	  	break;
                case SVMParser.SUB:
                    push(read(bytecode.getArg1()) - read(bytecode.getArg2()));
                    IP = IP +1 ;
            	  	break;
                case SVMParser.SUBI:
                	update(bytecode.getArg1(), read(bytecode.getArg1()) - Integer.parseInt(bytecode.getArg2()) );
                     IP = IP +1 ;
            	  	break;
                case SVMParser.MUL:
                    push(read(bytecode.getArg1()) * read(bytecode.getArg2()));
                    IP = IP +1 ;
            	  	break;
                case SVMParser.MULI:
                	update(bytecode.getArg1(), read(bytecode.getArg1()) * Integer.parseInt(bytecode.getArg2()) ) ;
                    IP = IP +1 ;
            	  	break;
                case SVMParser.DIV:
                    push(read(bytecode.getArg1()) / read(bytecode.getArg2()));
                    IP = IP +1 ;
            	  	break;
                case SVMParser.DIVI:
                    update(bytecode.getArg1(), read(bytecode.getArg1()) / Integer.parseInt(bytecode.getArg2()) );
                    IP = IP +1 ;
            	  	break;
                case SVMParser.POPR : //
                	update(bytecode.getArg1(), memory[SP +1]);
                	pop() ;
                	IP = IP +1 ;
            	  	break;
                case SVMParser.BRANCH:
                    address = IP + 1;
                    IP = code[address].getCode() ;
                    break;              
                case SVMParser.BRANCHEQ : //
                	if (read(bytecode.getArg1()) == read(bytecode.getArg2())){
                			address = IP +1;
                			IP = code[address].getCode() ;
                	} else IP = IP +2 ;
             	  	break;
			    case SVMParser.BRANCHLESSEQ :
					System.out.println(read(bytecode.getArg1()) + ">" + read(bytecode.getArg2()));
					if (read(bytecode.getArg1()) <= read(bytecode.getArg2())){
						address = IP +1;
						IP = code[address].getCode() ;
					} else IP = IP +2 ;
					break;
				case SVMParser.BRANCHEGT:
					if (read(bytecode.getArg1()) > read(bytecode.getArg2())){
						address = IP +1;
						IP = code[address].getCode() ;
					} else IP = IP +2 ;
					break;
				case SVMParser.BRANCHEQLT:
					if (read(bytecode.getArg1()) < read(bytecode.getArg2())){
						address = IP +1;
						IP = code[address].getCode() ;
					} else IP = IP +2 ;
					break;
				case SVMParser.BRANCHEQGTE:
					if (read(bytecode.getArg1()) >= read(bytecode.getArg2())){
						address = IP +1;
						IP = code[address].getCode() ;
					} else IP = IP +2 ;
					break;

			    case SVMParser.JUMPSUB :
					RA = IP +1 ;
					address = IP;
					IP = Integer.parseInt(code[address].getArg1())  ;
					break;
			    case SVMParser.RETURNSUB:
					IP = read(bytecode.getArg1()) ;
					break;
			    case SVMParser.HALT : //to print the result
					System.out.println("\nResult: " + A0 + "\n");
					return;
            } 
    	}   	  	
    } 
    
    private int pop() {
    		SP = SP +1 ;
    		return memory[SP] ;
    }
    
    private void push(int v) {
     		memory[SP] = v;
     		SP = SP -1 ;
    }
    
}