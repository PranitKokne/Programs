package com.bridgeit.designpattern;

public interface ShoppingCartVisitor {
	
	int visit(Book book);
	int visit(Fruit fruit);

}
