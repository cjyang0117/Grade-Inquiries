import java.io.*;

class main_grade_S { 
public static void main(String args[])throws IOException { 

BufferedReader br;
String[][] stu_ary;
String     str;
int f_pt;


Receiver_S RS = new Receiver_S(8000);
Sender_S SS = new Sender_S("127.0.0.1",8001);

stu_ary = new String[100][10];
f_pt=0;

while(true)
{
SS.send("*********************************"); 
SS.send("**        <<���Z�t��>>         **"); 
SS.send("*********************************"); 
SS.send("**  1. �s�W   2.�R��    3.�d�� **"); 
SS.send("**  4. �ק�   5.�s��    6.���� **"); 
SS.send("*********************************"); 
SS.send("��J�z����� (1~~6): "); 

str = RS.receive();  
int res = Integer.parseInt(str.trim());
      switch(res){
         case 1:    //�s�W
		   {
				SS.send("�п�J�Ǹ�:");      
				str = RS.receive(); //����õ��ݼƦr��J
				stu_ary[f_pt][0]=str.trim(); //�ٲ��Ů�
				SS.send("�п�J�m�W:");
				str = RS.receive(); 
				stu_ary[f_pt][1]=str.trim();
				SS.send("�п�J�K�X:");
				str = RS.receive();
				stu_ary[f_pt][2]=str.trim();
				SS.send("�п�J�ʧO:");
				str = RS.receive();
				stu_ary[f_pt][3]=str.trim();
				SS.send("�п�J�q��:");
				str = RS.receive();
				stu_ary[f_pt][4]=str.trim();
				SS.send("�п�J�a�} :");
				str = RS.receive(); 
				stu_ary[f_pt][5]=str.trim();
				SS.send("�п�J���妨�Z:");
				str = RS.receive();
				stu_ary[f_pt][6]=str.trim();
				SS.send("�п�J�^�妨�Z:");
				str = RS.receive();
				stu_ary[f_pt][7]=str.trim();
				int tot = Integer.parseInt(stu_ary[f_pt][6]) + Integer.parseInt(stu_ary[f_pt][7]);
				stu_ary[f_pt][8]=Integer.toString(tot);
				double avg = (Double.parseDouble(stu_ary[f_pt][6]) + Double.parseDouble(stu_ary[f_pt][7]))/2;
				stu_ary[f_pt][9]=Double.toString(avg);   
				f_pt++;
				//System.out.println("f_pt="+f_pt);
				break;
		   }
         case 2:   //�R��
		   {
				break;			  
		   }
		   
         case 3:     //�d��
           {
				SS.send("�п�J���d�M���ǥ;Ǹ�:");      
				str = RS.receive();  
				str = str.trim();
				int pt=10000;	
				for(int i=0; i<f_pt; i++)
				{
					if(str.equals(stu_ary[i][0]))
					{
						pt=i;
						break;
					}
				}
 	
				if (pt==10000)
					SS.send("�S�����Ǹ�!");					
				else
				{	
					SS.send(stu_ary[pt][0]+"\t"+stu_ary[pt][1]+"\t"+stu_ary[pt][2]+"\t"+stu_ary[pt][3]+"\t"+stu_ary[pt][4]+"\t"+stu_ary[pt][5]+"\t"+stu_ary[pt][6]+"\t"+stu_ary[pt][7]+"   "+stu_ary[pt][8]+"   "+stu_ary[pt][9]);
					
				}			
				break;
           }	
		   
         case 4:    //�ק�
           {
            break;			  
		   }   
		   
         case 5:
            {
				str = Integer.toString(f_pt);
				SS.send(str);
				for(int i=0; i<f_pt; i++)
				{
						SS.send(stu_ary[i][0]+"\t"+stu_ary[i][1]+"\t"+stu_ary[i][2]+"\t"+stu_ary[i][3]+"\t"+stu_ary[i][4]+"\t"+
						stu_ary[i][5]+"\t"+stu_ary[i][6]+"\t"+stu_ary[i][7]+"   "+stu_ary[i][8]+"   "+stu_ary[i][9]);
							
				} 
				break;
			}
         case 6:
            System.exit(0);
            break;

         default:
            SS.send("��J���~,�Э��s��J!");
            break;
       }
}	 
} 
}