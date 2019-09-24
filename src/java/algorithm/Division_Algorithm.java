/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

/**
 *
 * @author DLK-E1
 */
public class Division_Algorithm
{
    private String text;
    
    private int max_count;
    
    public void set_Values(String text,int max_count)
    {
        this.text=text;
        this.max_count=max_count;
    }
    public String[] Get_Process()
    {
        int div=text.length()/max_count;
        System.out.println(div);
        double dd=(double)text.length()/max_count;
        String dum=dd+"";
        long d=Long.parseLong(dum.substring(dum.lastIndexOf(".")+1,dum.length()));
        double remain=d*max_count;
        remain =(int) (Math.round (remain * 10000.0) / 10000.0);
        
        System.out.println("Remain    : "+remain);
        System.out.println("Division  : "+div);
        System.out.println("D Value   : "+d);
        int size=div;

        String val[]=new String[size];
        
        int flag=0,count=max_count;
        int k=0;
        for(k=0;k<div;k++)
        {
            String line="";
            if(div-1==k)
                count=text.length();
            for(int i=flag;i<count;i++)
            {
                line+=text.charAt(i);
            }
            flag+=max_count;
            count+=max_count;
            
            val[k]=line;
        }
       return val;
    }
    public static void main(String[] args)
    {
        Division_Algorithm d=new Division_Algorithm();
        d.set_Values("this is normal text.. the most want criminal thsidfsdf dsfldsjfds fklsd", 5);//text,maximum characters
        String val[]=d.Get_Process();
        for (String val1 : val) 
        {
            System.out.println(val1);
        }
    }
}
