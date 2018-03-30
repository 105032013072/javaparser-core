package com.github.javaparser.printer.concretesyntaxmodel;

import com.github.javaparser.ast.Node;
import com.github.javaparser.printer.SourcePrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

/**
 * A group of elements that could be in any order.
 */
public class CsmMix extends CsmElement {
    private List<CsmElement> elements;

    public CsmMix(List<CsmElement> elements) {
        if (elements == null) {
            throw new NullPointerException();
        }
        for (CsmElement csmElement : elements) {
			if(csmElement==null) throw new IllegalArgumentException("Null element in the mix");
		}
       /* if (elements.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Null element in the mix");
        }*/
        this.elements = elements;
    }

    public List<CsmElement> getElements() {
        return elements;
    }

    @Override
    public void prettyPrint(Node node, SourcePrinter printer) {
      //  elements.forEach(e -> e.prettyPrint(node, printer));
    	for (CsmElement csmElement : elements) {
    		csmElement.prettyPrint(node, printer);
		}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CsmMix csmMix = (CsmMix) o;

        return elements != null ? elements.equals(csmMix.elements) : csmMix.elements == null;
    }

    @Override
    public int hashCode() {
        return elements != null ? elements.hashCode() : 0;
    }

    @Override
    public String toString() {
    	List<String> list=new ArrayList<>();
    	for (CsmElement e : elements) {
    		list.add(e.toString());
		}
    	 return "CsmMix[" +StringUtils.join(list,", ")  + "]";
       // return "CsmMix[" + String.join(", ", elements.stream().map(e -> elements.toString()).collect(Collectors.toList())) + "]";
    }
}
