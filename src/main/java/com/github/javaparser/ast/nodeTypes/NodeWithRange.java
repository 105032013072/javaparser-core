package com.github.javaparser.ast.nodeTypes;

import com.github.javaparser.Position;
import com.github.javaparser.Range;
import com.github.javaparser.ast.Node;


/**
 * A node that has a Range, which is every Node.
 * 
 */
public abstract class NodeWithRange<N> {
	public abstract Range getRange();

	public abstract N setRange(Range range);

    /**
     * The begin position of this node in the source file.
     */
    public Position getBegin() {
    	Range range=getRange();
    	if(range!=null){
    		return range.begin;
    	}
    	return null;
        //return getRange().map(r -> r.begin);
    }

    /**
     * The end position of this node in the source file.
     */
    public Position getEnd() {
        /*return getRange().map(r -> r.end);*/
    	Range range=getRange();
    	if(range!=null){
    		return range.end;
    	}
    	return null;
    	
    }

    public boolean containsWithin(Node other) {
        if (getRange()!=null && other.getRange()!=null) {
            return getRange().contains(other.getRange());
        }
        return false;
    }

    /**
     * @deprecated use isAfter() on range
     */
    @Deprecated
    public boolean isPositionedAfter(Position position) {
    	
    	if(getRange()!=null){
    		return getRange().isAfter(position);
    	}else{
    		return false;
    	}
    	
    	
        /*return getRange().map(r -> r.isAfter(position)).orElse(false);*/
    }

    /**
     * @deprecated use isBefore() on range
     */
    @Deprecated
    public boolean isPositionedBefore(Position position) {
    	if(getRange()!=null){
    		return getRange().isBefore(position);
    	}else return false;
    	
       /* return getRange().map(r -> r.isBefore(position)).orElse(false);*/
    }
}
