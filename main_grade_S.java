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
SS.send("**        <<成績系統>>         **"); 
SS.send("*********************************"); 
SS.send("**  1. 新增   2.刪除    3.查詢 **"); 
SS.send("**  4. 修改   5.瀏覽    6.結束 **"); 
SS.send("*********************************"); 
SS.send("輸入您的選擇 (1~~6): "); 

str = RS.receive();  
int res = Integer.parseInt(str.trim());
      switch(res){
         case 1:    //新增
		   {
				SS.send("請輸入學號:");      
				str = RS.receive(); //停止並等待數字輸入
				stu_ary[f_pt][0]=str.trim(); //省略空格
				SS.send("請輸入姓名:");
				str = RS.receive(); 
				stu_ary[f_pt][1]=str.trim();
				SS.send("請輸入密碼:");
				str = RS.receive();
				stu_ary[f_pt][2]=str.trim();
				SS.send("請輸入性別:");
				str = RS.receive();
				stu_ary[f_pt][3]=str.trim();
				SS.send("請輸入電話:");
				str = RS.receive();
				stu_ary[f_pt][4]=str.trim();
				SS.send("請輸入地址 :");
				str = RS.receive(); 
				stu_ary[f_pt][5]=str.trim();
				SS.send("請輸入中文成績:");
				str = RS.receive();
				stu_ary[f_pt][6]=str.trim();
				SS.send("請輸入英文成績:");
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
         case 2:   //刪除
		   {
				break;			  
		   }
		   
         case 3:     //查詢
           {
				SS.send("請輸入欲查尋之學生學號:");      
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
					SS.send("沒有此學號!");					
				else
				{	
					SS.send(stu_ary[pt][0]+"\t"+stu_ary[pt][1]+"\t"+stu_ary[pt][2]+"\t"+stu_ary[pt][3]+"\t"+stu_ary[pt][4]+"\t"+stu_ary[pt][5]+"\t"+stu_ary[pt][6]+"\t"+stu_ary[pt][7]+"   "+stu_ary[pt][8]+"   "+stu_ary[pt][9]);
					
				}			
				break;
           }	
		   
         case 4:    //修改
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
            SS.send("輸入錯誤,請重新輸入!");
            break;
       }
}	 
} 
}