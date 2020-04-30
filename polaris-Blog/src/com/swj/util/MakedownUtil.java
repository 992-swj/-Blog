package com.swj.util;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.vladsch.flexmark.Extension;
import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.AttributeProvider;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;

public class MakedownUtil {
	public  static  String markedownToHtml(String markedown){
        Parser parser=Parser.builder().build();
        System.out.println("markedown"+markedown);
        Node document = parser.parse(markedown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }
	
	   
	public static void main(String[] args) {
		String str="| 1 | 2|"
				+ "| -- | --|"
				+ "| 123 | 123 |";
		
		String html2 = markedownToHtml(str);
		System.out.println(html2);
	}

}	
	