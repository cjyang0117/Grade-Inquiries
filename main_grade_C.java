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
         case 1:    //�s�W
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
         case 2:   //�R��
		   {
				break;			  
		   }
		   
         case 3:     //�d��
           {
				br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println(RC.receive());//System.out.println("�п�J���d�M���ǥ;Ǹ�:");      
				str = br.readLine();
				SC.send(str);
				System.out.println("�Ǹ�   �m�W   �K�X   �ʧO   �q��   �a�} ���妨�Z �^�妨�Z �`�� ����");
				System.out.println(RC.receive());
				System.out.println("");		
				break;
           }	
		   
         case 4:    //�ק�
           {
            break;			  
		   }   
		   
         case 5:
            {
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("�Ǹ�   �m�W   �K�X   �ʧO   �q��   �a�} ���妨�Z �^�妨�Z �`�� ����");
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
            System.out.println("��J���~,�Э��s��J!");
            break;
       }
}	 
} 
}