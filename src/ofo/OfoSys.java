package ofo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class OfoSys {
	//OFO����������ƽ̨
	public static void main(String[] args) {
		sys();
		
	}
	
	//���ڵ�ʱ��
	public static String nowTime() {
		Date now = new Date( );
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");

	    return ft.format(now);
		
	}
	
	public static void sys() {
		String line = "*****************************";
		String line2 = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
		String[] username = new String[99];	//��ע����˺�
		String[] pwd = new String[99];		//��ע�������
		String entername = "";	//������˺�
		String enterpwd = "";	//���������
		String option;			//����ѡ��
		boolean login = false;	//�Ƿ��¼�ɹ�
		Scanner input = new Scanner(System.in);
		int num;		//�������˵���Ҫ��ȡ��0
		boolean flag = false; //���г��Ƿ�����
		boolean exist = false; //�˻��Ƿ����
		
		int[] bikeNum = new int[99];	//���г����
		String[] bNum = new String[99]; 	//���г����
		int[] status = new int[99];	//���г�״̬
		String[] date = new String[99];	//���г�����
		int[] time = new int[99]; 	//���г����޴���
		String[] person = new String[99]; 	//���г�������
		String[] payback = new String[99];	//���г�Ӧ�û������� 
		String root = ""; //�ѵ�¼���û����û���
		
		//Ԥ�����г�1
		bikeNum[0] = 1;
		bNum[0] = "ofo-201807";
		status[0] = 1;
		date[0] = "���г�δ������";
		time[0] = 0;
		person[0] = "δ����";
		//Ԥ�����г�2
		bikeNum[1] = 2;
		bNum[1] = "ofo-201808";
		status[1] = 1;
		date[1] = "���г�δ������";
		time[1] = 0;
		person[1] = "δ����";
		//Ԥ�����г�3
		bikeNum[2] = 3;
		bNum[2] = "ofo-201809";
		status[2] = 2;
		date[2] = "2017-7-22 12:01:00";
		time[2] = 1;
		person[2] = "admin";
		
		//Ԥ���˺�
		username[0] = "admin";
		pwd[0] = "123";
		
		
		while(true) {
		
			System.out.println(line);
			System.out.println("OFO����������ƽ̨");
			System.out.println(line);
			
			System.out.print("����ϵͳʱ���ǣ�");
			System.out.println(nowTime());
			
			if(!login) {
				System.out.println("��¼״̬��δ��¼(ѡ��7��¼)");
			}else {
				System.out.println("��¼״̬����ӭ"+root+"��¼OFO����ϵͳ�������˳�ϵͳ������6");
			}
			
			System.out.println(line2);
			System.out.println("1�����OFO�ͺ�");
			System.out.println("2���鿴����OFO");
			System.out.println("3��ɾ��OFO");
			System.out.println("4������OFO");
			System.out.println("5���黹OFO");
			System.out.println("6���˳�ϵͳ");
			System.out.println("7����¼ϵͳ");
			System.out.print("��ѡ��");
			option = input.next();
			
			if(option.equals("1")) {
				//���OFO�ͺ�
				if(login == false) {	//û�е�¼�Ͱ���1���
					System.out.println("�ף��㵹���ȸ��ҵ�¼����");
					quit();
				}else {
					//��¼�ɹ���1���
					System.out.println(">>����ӭ�������г���ӽ��棡");
					System.out.print("���������г���ţ�");
					
					//ѭ�����հ׵ı��
					for(int i = 0; i < bNum.length; i++) {
						if(bNum[i] == null){
							bNum[i] = input.next();
							bNum[i] = "ofo-" + bNum[i];
							//����Ѵ���
							for(int j = 0; j < i; j++) {
								if(bNum[i] == bNum[j]) {
									bNum[i] = null;
									flag = true;
									break;
								}
								
								flag = false;
							}
							
							//����Ѵ��ڵ������ �������
							if(flag == true) {
								System.out.println("������ı���Ѵ���");
								quit();
								break;	//����ѭ��
							}else {
								//���г����
								bikeNum[i] = i + 1;
								//���г�״̬��Ĭ��Ϊ1
								status[i] = 1;
								//���� Ĭ��Ϊ"���г�δ�����޹�"
								date[i] = "���г�δ�����޹�";
								//���޴��� Ĭ��0
								time[i] = 0;
								//������ Ĭ��Ϊ"δ����"
								person[i] = "δ����";
								
								System.out.println("����[" + bNum[i] + "]��ӳɹ�");
								quit();
								break;//����ѭ��
							}
						}
					}
					
				}
				
			}else if(option.equals("2")) {
				//�鿴����OFO
				System.out.println(">>�鿴���г�");
				System.out.println("���\t���\t״̬\t����\t���޴���\t������");
				
				for(int i = 0; i < bNum.length; i++) {
					if(bNum[i] != null){
					
						System.out.println(bikeNum[i] + "\t" + bNum[i] + "\t" + status[i] + "\t" + date[i] + "\t" + time[i] + "\t" + person[i]);
				
					}
				}
				
				quit();
				
			}else if(option.equals("3")) {
				//ɾ��OFO
				if(root != "") {
					System.out.println("��������Ҫɾ����OFO���");
					String n = input.next();
					boolean a = false; //�ж���û���ҵ����г�
					
					//�鿴���г�Ҫɾ���ı���Ƿ����
					for(int i = 0; i < bikeNum.length; i++) {
						//���г�����
						if(n.equals(bNum[i])) {
							a = true;
							//�ж����г��Ƿ񱻽��
							if(status[i] == 2) {
								//���г������
								System.out.println("��Ǹ�������г��������޵��� ���޷�ɾ��");
								break;
							}else {
								//���г�û�б����
								while(true) {
									System.out.println("Σ�ղ�������ȷ�����Ƿ�ɾ��[" + n + "]?(y/n)");
									String confirm = input.next();
									
									if(confirm.equals("y")) {
										bNum[i] = null;
										bikeNum[i] = 0;
										status[i] = 0;
										date[i] = null;
										time[i] = 0;
										person[i] = null;
										payback[i] = null;
										System.out.println("ɾ��[" + n + "]�ɹ�");
										break;
										
									}else if(confirm.equals("n")) {
										break;
									}else {
										continue;
									}
								}
							}
						}
					}
					
					//���г�������
					if(a == false) {
						System.out.println("��Ҫɾ�������г������ڣ�������2�鿴���г���Ϣ");
					}
				}else {
					System.out.println("��磬���½����");
				}
				
				quit();
				
			}else if(option.equals("4")) {
				//����OFO
				if(root != "") {
				
					System.out.println(">>��ӭ�������г����޽���");
					System.out.println("���������г����:");
					
					String bike = input.next();
					bike = "ofo-" + bike;
					int i = 0;
					
					//������Ӧ�����г����
					while(i < bNum.length) {
						//�ҵ�֮��Ĳ���
						if(bike.equals(bNum[i])) {
							System.out.print("�����޵�����Ϊ:" + nowTime().substring(0, 10));
							
							System.out.println("---------------------");
							
							//�жϴ����г���û�б�����
							if(status[i] == 1) {
								//����״̬
								System.out.print("�������޵�����Ϊ��" + nowTime().substring(0, 10));
								
								System.out.print("���������Ĺ黹���ڣ�1-31����" + nowTime().substring(0, 8));
								int d = input.nextInt();
								
								payback[i] = nowTime().substring(0, 8) + Integer.toString(d) + nowTime().substring(10);
								status[i] = 2;
								time[i] += 1;
								date[i] = nowTime();
								person[i] = root;
								//��λ(����)	һ�����˶�����
								int day = (int)(difference(nowTime(), payback[i])/1000/60/60/24);
								int hour = (int)(difference(nowTime(), payback[i])/1000/60/60) - day*24;
								
								System.out.println("��һ������" + day + "�죬���Ϊ40��Ǯһ�죬�ϼ�" + (day*40+hour*0.16) + "Ԫ������һ�찴0.16/ÿСʱ����");
								System.out.println("��ϲ��," + bike.substring(5) + "���޳ɹ�");
								break;
									
							}else {
								//����״̬
								System.out.println("��Ǹ����OFO�Ѿ������ޣ���ȴ���͹黹");
								break;
							}
						}
						i++;
					}
					
					//������û���ҵ���Ӧ�ı��
					if(i == bNum.length) {
						System.out.println("û�д����г���ţ�������2�鿴����OFO���г���Ϣ");
					}
					
					System.out.println("---------------------");
				}else {
					System.out.println("��磬���¼����");
				}
				quit();
				
			}else if(option.equals("5")) {
				//�黹OFO
				if(root != "") {
					while(true) {
						System.out.println("��������Ҫ�黹���г��ı�ţ�");
						String d = input.next();
						boolean f = false;	//�ж��Ƿ�ѭ��������û���ҵ���Ӧ�����г�
						
						d = "ofo-" + d;
						System.out.println("�Ƿ�黹" + d + "��(y/n)");
						
						String o = input.next();
						if(o.equals("y")) {
							//������������Ƿ��ж�Ӧ�����г�
							for(int i = 0; i < bNum.length; i++) {
								if(d.equals(bNum[i])) {
									//�ж�Ӧ�����г����
									f = true;
									
									//�ж����г���û�б����
									if(status[i] == 2) {
										//�����
										
										//�жϸ����г��Ƿ��Ǹ��û����
										if(root.equals(person[i])) {
											//�Ǹ��û����
											System.out.println(d + "���ʱ��:" + date[i]);
											System.out.println("�黹ʱ��:" + nowTime());
											
											System.out.print("���ڼ���ʱ�����Ե�");
											
											//װ���õ�
											try {
												for(int j = 0; j < 5; j++) {
													Thread.sleep(1000);
													System.out.print(".");
												}
												System.out.println();
											}catch(Exception e) {
												e.printStackTrace();
											}
											
											//��������ٸ�Сʱ
											int diff = (int)(difference(date[i], nowTime())/1000/60/60);
											//�Ƿ�ʣ��������ٸ�Сʱ
											int hour = diff % 24;
											//������
											int day = (diff-hour)/24;
											
											if(day == 0) {
												//����һ��
												System.out.println("ʱ���Ϊ��" + hour + "Сʱ");
												System.out.println("ÿСʱ0.16Ԫ����" + hour + "Сʱ��Ӧ��" + (hour*0.16) + "Ԫ");
												
												//��״̬�ָ���δ����
												status[i] = 1;
												person[i] = "δ����";
												date[i] = nowTime();
												payback[i] = null;
												break;
												
											}else {
												//����һ��
												System.out.println("ʱ���Ϊ��" + day + "��" + hour + "Сʱ");
												System.out.println("40��Ǯһ�죬����һ�찴ÿСʱ0.16Ԫ����"+ day + "��" + hour + "Сʱ��Ӧ��" + (hour*0.16+day*40) + "Ԫ");
												
												//��״̬�ָ���δ����
												status[i] = 1;
												person[i] = "δ����";
												date[i] = nowTime();
												payback[i] = null;
												break;
											}
											
										}else {
											//���Ǹ��û����
											System.out.println("��磬�⳵�������İ���");
											break;
										}
										
									}else {
										//û�б����
										System.out.println("�����г�û�б����");
										break;
									}
									
								}
							}
							
							if(!f) {
								System.out.println("û����Ҫ�黹�����г���ţ�������2��ѯȷ����Ϣ");
								break;
							}
							
							break;
						}else if(o.equals("n")) {
							break;
						}else {
							continue;
						}
					}
				}else {
					System.out.println("��磬���¼����");
				}
				quit();
				
			}else if(option.equals("6")) {
				//�˳�ϵͳ
				String confirm;
				
				while(true) {
					System.out.println("�Ƿ�ȷ���˳�ϵͳ?(y/n)");
					confirm = input.next();
					
					if(confirm.equals("y")) {
						System.out.println("��ӭ�´�ʹ�ã�");
						root = "";
						login = false;
						break;
					}else if(confirm.equals("n")) {
						break;
					}else {
						continue;
					}
					
				}
				
				if(confirm.equals("y")) {
					break;
				}
				
			}else if(option.equals("7")) {
				//��¼ϵͳ
				
				//ע��
				root = "";
				login = false;
				exist = false;
				
				while(true) {	//��ֹ�û������˺��������
					System.out.println(line2);
					System.out.println(">>��ӭ�����¼ϵͳ");
					System.out.println(line2);
					
					System.out.print("�����������û�����");
					entername = input.next();
					System.out.print("�������������룺");
					enterpwd = input.next();
					
					for(int i = 0; i < username.length; i++) {
						
						//ѭ���鿴��û�ж�Ӧ������
						if(entername.equals(username[i])) {
							exist = true;
							if(enterpwd.equals(pwd[i].toString())) {
								root = username[i];
								login = true;
								break;
								
							}else {
								System.out.println("�����������������");
							}
							
						}
						
					}
					
					if(!exist) {
						//���û���û��ע��
						
						System.out.println("����δע�ᣬ������ע���ٵ�¼��");
						System.out.println(line2);
						
						boolean f = false;
						
						for(int i = 0; i < username.length; i++) {
							
							if(username[i] == null) {
								System.out.print("�����˺ţ�");
								username[i] = input.next();
								System.out.print("�������룺");
								pwd[i] = input.next();
								System.out.println(line2);
								System.out.println("�����˻�ע��ɹ���");
								System.out.println("�˺�Ϊ��" + username[i]);
								System.out.println("����Ϊ��" + pwd[i]);
								System.out.println("���μ��������ϣ�Ŀǰϵͳ�Ѿ�Ϊ���Զ���¼��");
								
								root = username[i];
								login = true;
								
								f = true;
								System.out.println(line2);
								quit();
								break;
							}
						}
						
						if(f == false) {
							System.out.println("��Ǹ���û��Ѿ�����");
						}
						
						break;	//����ѭ��
					}else {
						break;
						
					}
				}	
			}else {
				System.out.println("û�����ѡ�������ѡ��");
			}
		}
		
	}
	
	public static int quit() {
		int num;
		Scanner input = new Scanner(System.in);
		
		while(true) {
			//��ֹ�û����벻��0
			System.out.print("������0�������˵�");
			num = input.nextInt();
			
			if(num == 0) {
				break;	//Ϊ0������
			}
		}
		
		return num;
	}
	
	//����ʱ���(��λ������)
	public static long difference(String now, String future) {
		long a = 0;
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date1 = ft.parse(now);
			Date date2 = ft.parse(future);
			
			a = date2.getTime() - date1.getTime();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return a;
	}
	
}
