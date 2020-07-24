import java.io.*;

class main_grade_C { 
public static void main(String args[])throws IOException { 

BufferedReader br;
String     str;



Sender SC = new Sender("127.0.0.1",8000);
Receiver RC = new Receiver(8001);

while(true)
{
	for(int i=1 ; i<=7 ; i++)
	{
		str = RC.receive();
		System.out.println(str); 
	}


br = new BufferedReader(new InputStreamReader(System.in));
str = br.readLine();  
SC.send(str);
int res = Integer.parseInt(str);
      switch(res){
         case 1:    //新增
		   {
				br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println(RC.receive()); 
				str = br.readLine(); 
				SC.send(str);
				System.out.println(RC.receive());  
				str = br.readLine(); 
				SC.send(str);
				System.out.println(RC.receive());
				str = br.readLine(); 
				SC.send(str);
				System.out.println(RC.receive());
				str = br.readLine(); 
				SC.send(str);
				System.out.println(RC.receive());
				str = br.readLine(); 
				SC.send(str);
				System.out.println(RC.receive());
				str = br.readLine(); 
				SC.send(str);
				System.out.println(RC.receive());
				str = br.readLine(); 
				SC.send(str);
				System.out.println(RC.receive());
				str = br.readLine(); 
				SC.send(str);
				break;
		   }
         case 2:   //刪除
		   {
				break;			  
		   }
		   
         case 3:     //查詢
           {
				br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println(RC.receive());//System.out.println("請輸入欲查尋之學生學號:");      
				str = br.readLine();
				SC.send(str);
				System.out.println("學號   姓名   密碼   性別   電話   地址 中文成績 英文成績 總分 平均");
				System.out.println(RC.receive());
				System.out.println("");		
				break;
           }	
		   
         case 4:    //修改
           {
            break;			  
		   }   
		   
         case 5:
            {
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("學號   姓名   密碼   性別   電話   地址 中文成績 英文成績 總分 平均");
				str = RC.receive();
				int f_pt = Integer.parseInt(str.trim());
				for(int i=0; i<f_pt; i++)
				{
					System.out.println(RC.receive());		
				}
				System.out.println("-------------------------------------------------------------------------");   
				
				break;
			}
         case 6:
            System.exit(0);
            break;

         default:
            System.out.println("輸入錯誤,請重新輸入!");
            break;
       }
}	 
} 
}