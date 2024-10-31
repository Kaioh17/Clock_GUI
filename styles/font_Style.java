package styles;

import javax.swing.*;

//import src.Main;

import java.awt.*;
// import java.awt.event.*;

public class font_Style  {

    private String fontName;
    private int style;
    private int size;


    //initialized font style method for easier editing and control
    public static final font_Style ROMAN = new font_Style("Times New Roman",Font.PLAIN,55);
    public static final font_Style roman = new font_Style("Times New Roman",Font.PLAIN,15);
    public static final font_Style ROMANII = new font_Style("Malgun Gothic",Font.PLAIN,35);

    
    public font_Style(String fontName, int style,int size)
    {
        this.fontName = fontName;
        this.style = style;
        this.size = size;
    }

    //method to access the font object
    public Font getFont() 
    {
        return new Font(fontName, style,size);
    }

}
