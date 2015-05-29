package kmatrix;

import java.util.LinkedList;

class KStack {
	
	LinkedList<Atom> stack;

	public KStack() {
		this.stack=new LinkedList<Atom>();
	}

	public void push(Atom atom) { stack.add(0, atom); }
	
	public Atom pop() { 
		Atom atom=stack.get(0);
		stack.remove(0);	 			 
		return atom;					 
	}

	public Atom peek()     { return stack.get(0); 			}
	public boolean empty() { return (this.stack.size()==0); }

	public boolean contains(Atom atom) { return this.stack.contains(atom); }
	public int size() { return this.stack.size(); }
}