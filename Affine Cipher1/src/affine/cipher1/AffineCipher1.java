/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package affine.cipher1;

import java.util.Scanner;

/**
 *
 * @author Anchal
 */
public class AffineCipher1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
		Scanner sc=new Scanner(System.in);
		int key1,key2,k11=0,ch,ct,pt,l;
		char t;
		int fact26[]={1,2,13};
		int co=0;
		char c[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',' '};
		System.out.println("1. Encryption");
		System.out.println("2. Decryption");
		System.out.print("Enter your choice :");
		ch=sc.nextInt();
		switch(ch)
		{
			case 1:	Scanner dc=new Scanner(System.in);	
				System.out.print("Enter PlainText : ");		
				String num=dc.nextLine();
				num=num.toUpperCase();
				l=num.length();
				int k=0;
				int a[]=new int[l];
				char cte[]=new char[l];
				char[] num1=num.toCharArray();
				for(int j=0;j<num1.length;j++)
				{
             		for(int i=0;i<c.length;i++)
					{
             			if(num1[j]==c[i])
              			{
              				if(num1[j]!=' ')
                			{
                				a[k]=i;
                			}
                			else
                			{
                				a[k]=32;
                			}
	              			k=k+1;
                       	}
                    }
                }
				System.out.print("Enter Key 1 :");
				key1=sc.nextInt();
				for(int i=0;i<3;i++)
				{
					if(key1%fact26[i]==0)
						co++;
				}
				if(co>1)
				{
					System.out.println("Key is inappropriate i.e. "+key1+" and 26 is not coprime");
					break;
				}
				System.out.print("Enter Key 2 :");
				key2=sc.nextInt();
				System.out.print("Encrypted message :");
				for(int i=0;i<a.length;i++)
				{
					if(a[i]!=32)
					{
						ct=(a[i]*key1+key2)%26;
						cte[i]=c[ct];
					}
					else
					{
						cte[i]=(char)a[i];
					}
					System.out.print(cte[i]);
				}
				break;
			case 2:	Scanner ac=new Scanner(System.in);
				System.out.print("Enter CipherText : ");		
				num=ac.nextLine();
				num=num.toUpperCase();
				l=num.length();
				int k1=0;
				int a1[]=new int[l];
				char cte1[]=new char[l];
				char[] num2=num.toCharArray();
				for(int j=0;j<num2.length;j++)
				{
             		for(int i=0;i<c.length;i++)
					{
             			if(num2[j]==c[i])
              			{
              				if(num2[j]!=' ')
                			{
                				a1[k1]=i;
                			}
                			else
                			{
                				a1[k1]=32;
                			}
	              			k1=k1+1;
                       	}
                    }
                }
				System.out.print("Enter Key 1 :");
				key1=sc.nextInt();
				for(int i=0;i<3;i++)
				{
					if(key1%fact26[i]==0)
						co++;
				}
				if(co>1)
				{
					System.out.println("Key is inappropriate i.e. "+key1+" and 26 is not coprime");
					break;
				}
				System.out.print("Enter Key 2 :");
				key2=sc.nextInt();
				for(int i=0;i<26;i++)
				{
					key11=i;
					if((key1*i)%26==1)
					break;
				}
				System.out.print("Decrypted message :");
				for(int i=0;i<a1.length;i++)
				{
					if(a1[i]!=32)
					{
						ct=((a1[i]-key2)*key11)%26;
						if(ct<0)
						{
							ct=ct+26;
						}
						cte1[i]=c[ct];
					}
					else
					{
						cte1[i]=(char)a1[i];
					}
					System.out.print(cte1[i]);
				}
				break;
			default:	System.out.println("Wrong Choice");
		}
	}
    }
    

