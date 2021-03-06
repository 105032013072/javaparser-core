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

package com.github.javaparser.printer;

import static com.github.javaparser.utils.Utils.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.metamodel.NodeMetaModel;
import com.github.javaparser.metamodel.PropertyMetaModel;

/**
 * Outputs a Graphviz diagram of the AST.
 */
public class DotPrinter {

    private int nodeCount;
    private final boolean outputNodeType;

    public DotPrinter(boolean outputNodeType) {
        this.outputNodeType = outputNodeType;
    }

    public String output(Node node) {
        nodeCount = 0;
        StringBuilder output = new StringBuilder();
        output.append("digraph {");
        output(node, null, "root", output);
        output.append(System.lineSeparator() + "}");
        return output.toString();
    }

    public void output(Node node, String parentNodeName, String name, StringBuilder builder) {
        assertNotNull(node);
        NodeMetaModel metaModel = node.getMetaModel();
        List<PropertyMetaModel> allPropertyMetaModels = metaModel.getAllPropertyMetaModels();
       /* List<PropertyMetaModel> attributes = allPropertyMetaModels.stream().filter(PropertyMetaModel::isAttribute)
                .filter(PropertyMetaModel::isSingular).collect(toList());*/
        List<PropertyMetaModel> attributes=new ArrayList<>();
        for (PropertyMetaModel propertyMetaModel : allPropertyMetaModels) {
			if(propertyMetaModel.isAttribute()&& propertyMetaModel.isSingular()) attributes.add(propertyMetaModel);
		}
        
        /*List<PropertyMetaModel> subNodes = allPropertyMetaModels.stream().filter(PropertyMetaModel::isNode)
                .filter(PropertyMetaModel::isSingular).collect(toList());*/
        List<PropertyMetaModel> subNodes=new ArrayList<>();
        for (PropertyMetaModel propertyMetaModel : allPropertyMetaModels) {
			if(propertyMetaModel.isNode()&& propertyMetaModel.isSingular()) subNodes.add(propertyMetaModel);
		}
       
      /*  List<PropertyMetaModel> subLists = allPropertyMetaModels.stream().filter(PropertyMetaModel::isNodeList)
                .collect(toList());*/
        List<PropertyMetaModel> subLists=new ArrayList<>();
        for (PropertyMetaModel propertyMetaModel : allPropertyMetaModels) {
			if(propertyMetaModel.isNodeList()) subLists.add(propertyMetaModel);
		}
        

        String ndName = nextNodeName();
        if (outputNodeType)
            builder.append(System.lineSeparator() + ndName + " [label=\"" + name + " (" + metaModel.getTypeName()
                    + ")\"];");
        else
            builder.append(System.lineSeparator() + ndName + " [label=\"" + name + "\"];");

        if (parentNodeName != null)
            builder.append(System.lineSeparator() + parentNodeName + " -> " + ndName + ";");

        for (PropertyMetaModel a : attributes) {
            String attrName = nextNodeName();
            builder.append(System.lineSeparator() + attrName + " [label=\"" + a.getName() + "='"
                    + a.getValue(node).toString() + "'\"];");
            builder.append(System.lineSeparator() + ndName + " -> " + attrName + ";");

        }

        for (PropertyMetaModel sn : subNodes) {
            Node nd = (Node) sn.getValue(node);
            if (nd != null)
                output(nd, ndName, sn.getName(), builder);
        }

        for (PropertyMetaModel sl : subLists) {
            NodeList<? extends Node> nl = (NodeList<? extends Node>) sl.getValue(node);
            if (nl != null && nl.isNonEmpty()) {
                String ndLstName = nextNodeName();
                builder.append(System.lineSeparator() + ndLstName + " [label=\"" + sl.getName() + "\"];");
                builder.append(System.lineSeparator() + ndName + " -> " + ndLstName + ";");
                String slName = sl.getName().substring(0, sl.getName().length() - 1);
                for (Node nd : nl)
                    output(nd, ndLstName, slName, builder);
            }
        }
    }

    private String nextNodeName() {
        return "n" + (nodeCount++);
    }
}
