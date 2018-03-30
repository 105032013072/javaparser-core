package com.github.javaparser.printer;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.metamodel.NodeMetaModel;
import com.github.javaparser.metamodel.PropertyMetaModel;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import static com.github.javaparser.utils.Utils.assertNotNull;


/**
 * Outputs a JSON file containing the AST meant for inspecting it.
 */
public class JsonPrinter {
    private final boolean outputNodeType;

    public JsonPrinter(boolean outputNodeType) {
        this.outputNodeType = outputNodeType;
    }

    public String output(Node node) {
        return output(node, null, 0);
    }

    public String output(Node node, String name, int level) {
        assertNotNull(node);
        NodeMetaModel metaModel = node.getMetaModel();
        List<PropertyMetaModel> allPropertyMetaModels = metaModel.getAllPropertyMetaModels();
       // List<PropertyMetaModel> attributes = allPropertyMetaModels.stream().filter(PropertyMetaModel::isAttribute).filter(PropertyMetaModel::isSingular).collect(toList());
        List<PropertyMetaModel> attributes=new ArrayList<>();
        for (PropertyMetaModel p : allPropertyMetaModels) {
			if(p.isAttribute() && p.isSingular()) attributes.add(p);
		}
        
       // List<PropertyMetaModel> subNodes = allPropertyMetaModels.stream().filter(PropertyMetaModel::isNode).filter(PropertyMetaModel::isSingular).collect(toList());
        List<PropertyMetaModel> subNodes=new ArrayList<>();
        for (PropertyMetaModel p : allPropertyMetaModels) {
			if(p.isNode()&& p.isSingular()) subNodes.add(p);
		}
        
       // List<PropertyMetaModel> subLists = allPropertyMetaModels.stream().filter(PropertyMetaModel::isNodeList).collect(toList());
        List<PropertyMetaModel> subLists=new ArrayList<>();
        for (PropertyMetaModel propertyMetaModel : allPropertyMetaModels) {
			if(propertyMetaModel.isNodeList()) subLists.add(propertyMetaModel);
		}
        
        final List<String> content = new ArrayList<>();

        if (outputNodeType) {
            content.add(q("type") + ":" + q(metaModel.getTypeName()));
        }

        for (PropertyMetaModel attributeMetaModel : attributes) {
            content.add(q(attributeMetaModel.getName()) + ":" + q(attributeMetaModel.getValue(node).toString()));
        }

        for (PropertyMetaModel subNodeMetaModel : subNodes) {
            Node value = (Node) subNodeMetaModel.getValue(node);
            if (value != null) {
                content.add(output(value, subNodeMetaModel.getName(), level + 1));
            }
        }

        for (PropertyMetaModel subListMetaModel : subLists) {
            NodeList<? extends Node> subList = (NodeList<? extends Node>) subListMetaModel.getValue(node);
            if (subList != null && !subList.isEmpty()) {
                final List<String> listContent = new ArrayList<>();
                for (Node subListNode : subList) {
                    listContent.add(output(subListNode, null, level + 1));
                }
               // content.add(listContent.stream().collect(Collectors.joining(",", q(subListMetaModel.getName()) + ":[", "]")));
                String str=q(subListMetaModel.getName())+ ":["+StringUtils.join(listContent,",")+"]";
                content.add(str);
            }
        }

        if (name == null) {
           // return content.stream().collect(Collectors.joining(",", "{", "}"));
        	return "{"+StringUtils.join(content,",")+"}";
        }
       // return content.stream().collect(Collectors.joining(",", q(name) + ":{", "}"));
        return q(name) + ":{"+StringUtils.join(content,",")+"}";
    }

    private static String q(String value) {
        return "\"" + value.replace("\"", "\\\"") + "\"";
    }
}
