package sem_an;

import ast.TypeNode;

import java.util.Hashtable;
import java.util.Stack;

public class SymbolTable{
	private Stack<Hashtable<String, sem_an.SymbolTableEntry>> symbolTable;

	public SymbolTable() {
		symbolTable = new Stack<>();
	}

	public SymbolTable(Stack<Hashtable<String, sem_an.SymbolTableEntry>> symbolTable) {
		this.symbolTable = new Stack<Hashtable<String, sem_an.SymbolTableEntry>>();
		for(Hashtable<String, sem_an.SymbolTableEntry> entry: symbolTable) {
			Hashtable<String, sem_an.SymbolTableEntry> newHash = new Hashtable<String, sem_an.SymbolTableEntry>();
			for(String k: entry.keySet()) {
				sem_an.SymbolTableEntry se = entry.get(k);
				sem_an.SymbolTableEntry newSe = new sem_an.SymbolTableEntry(se.getLabel(), se.getType(), se.getStatus(), se.getOffset());
				newHash.put(k,newSe);
			}
			this.symbolTable.push(newHash);
		}
	}

	public Stack<Hashtable<String, sem_an.SymbolTableEntry>> getSymbolTable() {
		return this.symbolTable;
	};
	
	public SymbolTable(String elem, sem_an.SymbolTableEntry st) {
		symbolTable = new Stack<>();
		Hashtable<String, sem_an.SymbolTableEntry> current = new Hashtable<String, sem_an.SymbolTableEntry>();
		current.put(elem, st);
		symbolTable.push(current);
	}
	public Hashtable<String, sem_an.SymbolTableEntry> get(int i) {
		return symbolTable.get(i);
	}
	public int getSize() {return symbolTable.size();}
	public int nesting() {
		return symbolTable.size() - 1;
	}

	public sem_an.SymbolTableEntry lookup(String id) {
		int n = symbolTable.size()-1;
		boolean found = false;
		sem_an.SymbolTableEntry result = null;
		while (n>-1 && !found) {
			Hashtable<String, sem_an.SymbolTableEntry> x = symbolTable.get(n);
			if(x.get(id) != null) {
				found = true;
				result = x.get(id);
			} else n-=1;
		}
		return result;
	}

	public sem_an.SymbolTableEntry topLookup(String id) {
		int n = symbolTable.size()-1;
		Hashtable<String, sem_an.SymbolTableEntry> x = symbolTable.get(n);
		return x.get(id);
	}

	public int nestingLookup(String id) {
		int n = symbolTable.size()-1;
		boolean found = false;

		while (n>0 && !found) {
			Hashtable<String, sem_an.SymbolTableEntry> x = symbolTable.get(n);

			if(this.lookup(id).getOffset() == -1) {
				//contains
				if(x.containsKey(id)) {
					found = true;
				} else n-=1;
			} else {
				if(x.containsKey(id)) {
					found = true;
				} else n-=1;
			}


		}
		return n;
	}

	public void insert(String id, TypeNode type, int offset) {
		Hashtable<String, sem_an.SymbolTableEntry> x = symbolTable.pop();
		sem_an.SymbolTableEntry st = new sem_an.SymbolTableEntry(id, type, sem_an.Status.DECLARED, offset);
		x.put(id, st);
		symbolTable.push(x);
	}

	public void insert(String id, TypeNode type, int offset, String label) {
		Hashtable<String, sem_an.SymbolTableEntry> x = symbolTable.pop();
		sem_an.SymbolTableEntry st = new sem_an.SymbolTableEntry(label, type, Status.DECLARED, offset);
		x.put(id, st);
		symbolTable.push(x);
	}



	public void enterInNewBlock() {
		this.symbolTable.push(new Hashtable<String, SymbolTableEntry>());
	}

	public void exitFromBlock() {
		this.symbolTable.pop();
	}

}
