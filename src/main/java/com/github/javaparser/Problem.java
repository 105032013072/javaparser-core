/*
 * Copyright (C) 2007-2010 Júlio Vilmar Gesser.
 * Copyright (C) 2011, 2013-2016 The JavaParser Team.
 *
 * This file is part of JavaParser.
 *
 * JavaParser can be used either under the terms of
 * a) the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * b) the terms of the Apache License
 *
 * You should have received a copy of both licenses in LICENCE.LGPL and
 * LICENCE.APACHE. Please refer to those files for details.
 *
 * JavaParser is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 */

package com.github.javaparser;

import java.util.Comparator;


import static com.github.javaparser.utils.Utils.EOL;
import static com.github.javaparser.utils.Utils.assertNotNull;

/**
 * A problem that was encountered during parsing.
 */
public class Problem {
    private final String message;
    private final TokenRange location;
    private final Throwable cause;

    public Problem(String message, TokenRange location, Throwable cause) {
        assertNotNull(message);

        this.message = message;
        this.location = location;
        this.cause = cause;
    }

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder(getVerboseMessage());
        if (cause != null) {
            str.append(EOL).append("Problem stacktrace : ").append(EOL);
            for (int i = 0; i < cause.getStackTrace().length; i++) {
                StackTraceElement ste = cause.getStackTrace()[i];
                str.append("  ").append(ste.toString());
                if (i + 1 != cause.getStackTrace().length)
                    str.append(EOL);
            }
        }
        return str.toString();
    }

    /**
     * @return the message that was passed into the constructor.
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return the message plus location information.
     */
    public String getVerboseMessage() {
       // return getLocation().map(l -> l.getBegin().getRange().map(r -> r.begin.toString()).orElse("(line ?,col ?)") + " " + message).orElse(message);
    	String msg="";
    	if(getLocation()!=null){
    		Range range=getLocation().getBegin().getRange();
    		if(range!=null){
    			msg=range.begin.toString()+" "+message;
    		}else msg="(line ?,col ?)"+" "+message;
    	}else msg=message;
    	return msg;
    }

    /**
     * @return the location that was passed into the constructor.
     */
    public TokenRange getLocation() {
        return location;
    }

    /**
     * @deprecated use getLocation()
     */
    @Deprecated
    public TokenRange getRange() {
        return getLocation();
    }

    /**
     * @return the cause that was passed into the constructor.
     */
    public Throwable getCause() {
        return cause;
    }

    /**
     * Sorts problems on position.
     */
   /* public static Comparator<Problem> PROBLEM_BY_BEGIN_POSITION = (a, b) -> {
        final Optional<Position> aBegin= a.getLocation().flatMap(l -> l.getBegin().getRange().map(r -> r.begin));
        final Optional<Position> bBegin = b.getLocation().flatMap(l -> l.getBegin().getRange().map(r -> r.begin));

        if (aBegin.isPresent() && bBegin.isPresent()) {
            return aBegin.get().compareTo(bBegin.get());
        }
        if (a.getLocation().isPresent() || b.getLocation().isPresent()) {
            if (a.getLocation().isPresent()) {
                return 1;
            }
            return -1;
        }
        return 0;
    };*/
    
    public static Comparator<Problem> PROBLEM_BY_BEGIN_POSITION=new Comparator<Problem>() {

		@Override
		public int compare(Problem a, Problem b) {
			final Position aBegin=a.getLocation().getBegin().getRange().begin;
			final Position bBegin=b.getLocation().getBegin().getRange().begin;
			if(aBegin!=null && bBegin!=null){
				return aBegin.compareTo(bBegin);
			}
			
			if (a.getLocation()!=null || b.getLocation()!=null) {
	            if (a.getLocation()!=null) {
	                return 1;
	            }
	            return -1;
	        }
	        return 0;
		}
	};


}
