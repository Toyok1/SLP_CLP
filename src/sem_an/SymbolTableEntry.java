package sem_an;

import ast.TypeNode;

public class SymbolTableEntry {
	private String label;
	private TypeNode type;
	private int offset;
	private sem_an.Status status;
	
	public SymbolTableEntry(String l, TypeNode t, sem_an.Status s, int offset) {
		this.label = l;
		this.type = t;
		this.status = s;
		this.offset = offset;
	}

	public String getLabel() {
		return this.label;
	}

	public TypeNode getType() {
		return this.type;
	}

	public sem_an.Status getStatus() {
		return this.status;
	}

	public void setInitialized() {
		this.status = sem_an.Status.INITIALIZED;
	}

	public void setDeclared() { this.status = Status.DECLARED;}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
}