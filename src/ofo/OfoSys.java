package ofo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class OfoSys {
	//OFO共享单车租赁平台
	public static void main(String[] args) {
		sys();
		
	}
	
	//现在的时间
	public static String nowTime() {
		Date now = new Date( );
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");

	    return ft.format(now);
		
	}
	
	public static void sys() {
		String line = "*****************************";
		String line2 = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
		String[] username = new String[99];	//已注册的账号
		String[] pwd = new String[99];		//已注册的密码
		String entername = "";	//输入的账号
		String enterpwd = "";	//输入的密码
		String option;			//功能选择
		boolean login = false;	//是否登录成功
		Scanner input = new Scanner(System.in);
		int num;		//返回主菜单需要获取的0
		boolean flag = false; //自行车是否被租赁
		boolean exist = false; //账户是否存在
		
		int[] bikeNum = new int[99];	//自行车序号
		String[] bNum = new String[99]; 	//自行车编号
		int[] status = new int[99];	//自行车状态
		String[] date = new String[99];	//自行车日期
		int[] time = new int[99]; 	//自行车租赁次数
		String[] person = new String[99]; 	//自行车租赁人
		String[] payback = new String[99];	//自行车应该还车日期 
		String root = ""; //已登录的用户的用户名
		
		//预设自行车1
		bikeNum[0] = 1;
		bNum[0] = "ofo-201807";
		status[0] = 1;
		date[0] = "自行车未被租赁";
		time[0] = 0;
		person[0] = "未租赁";
		//预设自行车2
		bikeNum[1] = 2;
		bNum[1] = "ofo-201808";
		status[1] = 1;
		date[1] = "自行车未被租赁";
		time[1] = 0;
		person[1] = "未租赁";
		//预设自行车3
		bikeNum[2] = 3;
		bNum[2] = "ofo-201809";
		status[2] = 2;
		date[2] = "2017-7-22 12:01:00";
		time[2] = 1;
		person[2] = "admin";
		
		//预设账号
		username[0] = "admin";
		pwd[0] = "123";
		
		
		while(true) {
		
			System.out.println(line);
			System.out.println("OFO共享单车租赁平台");
			System.out.println(line);
			
			System.out.print("现在系统时间是：");
			System.out.println(nowTime());
			
			if(!login) {
				System.out.println("登录状态：未登录(选择7登录)");
			}else {
				System.out.println("登录状态：欢迎"+root+"登录OFO租赁系统，如需退出系统请输入6");
			}
			
			System.out.println(line2);
			System.out.println("1、添加OFO型号");
			System.out.println("2、查看所有OFO");
			System.out.println("3、删除OFO");
			System.out.println("4、租赁OFO");
			System.out.println("5、归还OFO");
			System.out.println("6、退出系统");
			System.out.println("7、登录系统");
			System.out.print("请选择：");
			option = input.next();
			
			if(option.equals("1")) {
				//添加OFO型号
				if(login == false) {	//没有登录就按了1添加
					System.out.println("亲，你倒是先给我登录啊！");
					quit();
				}else {
					//登录成功后按1添加
					System.out.println(">>大神欢迎进入自行车添加界面！");
					System.out.print("请输入自行车编号：");
					
					//循环出空白的编号
					for(int i = 0; i < bNum.length; i++) {
						if(bNum[i] == null){
							bNum[i] = input.next();
							bNum[i] = "ofo-" + bNum[i];
							//编号已存在
							for(int j = 0; j < i; j++) {
								if(bNum[i] == bNum[j]) {
									bNum[i] = null;
									flag = true;
									break;
								}
								
								flag = false;
							}
							
							//编号已存在的情况下 不予添加
							if(flag == true) {
								System.out.println("您输入的编号已存在");
								quit();
								break;	//跳出循环
							}else {
								//自行车序号
								bikeNum[i] = i + 1;
								//自行车状态，默认为1
								status[i] = 1;
								//日期 默认为"自行车未被租赁过"
								date[i] = "自行车未被租赁过";
								//租赁次数 默认0
								time[i] = 0;
								//租赁人 默认为"未租赁"
								person[i] = "未租赁";
								
								System.out.println("您的[" + bNum[i] + "]添加成功");
								quit();
								break;//跳出循环
							}
						}
					}
					
				}
				
			}else if(option.equals("2")) {
				//查看所有OFO
				System.out.println(">>查看自行车");
				System.out.println("序号\t编号\t状态\t日期\t租赁次数\t租赁人");
				
				for(int i = 0; i < bNum.length; i++) {
					if(bNum[i] != null){
					
						System.out.println(bikeNum[i] + "\t" + bNum[i] + "\t" + status[i] + "\t" + date[i] + "\t" + time[i] + "\t" + person[i]);
				
					}
				}
				
				quit();
				
			}else if(option.equals("3")) {
				//删除OFO
				if(root != "") {
					System.out.println("请输入您要删除的OFO编号");
					String n = input.next();
					boolean a = false; //判断有没有找到自行车
					
					//查看自行车要删除的编号是否存在
					for(int i = 0; i < bikeNum.length; i++) {
						//自行车存在
						if(n.equals(bNum[i])) {
							a = true;
							//判断自行车是否被借出
							if(status[i] == 2) {
								//自行车被借出
								System.out.println("抱歉，该自行车正在租赁当中 您无法删除");
								break;
							}else {
								//自行车没有被借出
								while(true) {
									System.out.println("危险操作，请确定您是否删除[" + n + "]?(y/n)");
									String confirm = input.next();
									
									if(confirm.equals("y")) {
										bNum[i] = null;
										bikeNum[i] = 0;
										status[i] = 0;
										date[i] = null;
										time[i] = 0;
										person[i] = null;
										payback[i] = null;
										System.out.println("删除[" + n + "]成功");
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
					
					//自行车不存在
					if(a == false) {
						System.out.println("您要删除的自行车不存在，请输入2查看自行车信息");
					}
				}else {
					System.out.println("大哥，你登陆啊！");
				}
				
				quit();
				
			}else if(option.equals("4")) {
				//租赁OFO
				if(root != "") {
				
					System.out.println(">>欢迎进入自行车租赁界面");
					System.out.println("请输入自行车编号:");
					
					String bike = input.next();
					bike = "ofo-" + bike;
					int i = 0;
					
					//查找相应的自行车标号
					while(i < bNum.length) {
						//找到之后的操作
						if(bike.equals(bNum[i])) {
							System.out.print("您租赁的日期为:" + nowTime().substring(0, 10));
							
							System.out.println("---------------------");
							
							//判断此自行车有没有被租赁
							if(status[i] == 1) {
								//空闲状态
								System.out.print("您的租赁的日期为：" + nowTime().substring(0, 10));
								
								System.out.print("请输入您的归还日期（1-31）：" + nowTime().substring(0, 8));
								int d = input.nextInt();
								
								payback[i] = nowTime().substring(0, 8) + Integer.toString(d) + nowTime().substring(10);
								status[i] = 2;
								time[i] += 1;
								date[i] = nowTime();
								person[i] = root;
								//单位(毫秒)	一共租了多少天
								int day = (int)(difference(nowTime(), payback[i])/1000/60/60/24);
								int hour = (int)(difference(nowTime(), payback[i])/1000/60/60) - day*24;
								
								System.out.println("您一共租了" + day + "天，租金为40块钱一天，合计" + (day*40+hour*0.16) + "元，不满一天按0.16/每小时计算");
								System.out.println("恭喜您," + bike.substring(5) + "租赁成功");
								break;
									
							}else {
								//租赁状态
								System.out.println("抱歉！该OFO已经被租赁，请等待租客归还");
								break;
							}
						}
						i++;
					}
					
					//遍历后没有找到对应的编号
					if(i == bNum.length) {
						System.out.println("没有此自行车编号，请输入2查看所有OFO自行车信息");
					}
					
					System.out.println("---------------------");
				}else {
					System.out.println("大哥，你登录啊！");
				}
				quit();
				
			}else if(option.equals("5")) {
				//归还OFO
				if(root != "") {
					while(true) {
						System.out.println("请输入需要归还自行车的编号：");
						String d = input.next();
						boolean f = false;	//判断是否循环结束都没有找到对应的自行车
						
						d = "ofo-" + d;
						System.out.println("是否归还" + d + "？(y/n)");
						
						String o = input.next();
						if(o.equals("y")) {
							//遍历数组查找是否有对应的自行车
							for(int i = 0; i < bNum.length; i++) {
								if(d.equals(bNum[i])) {
									//有对应的自行车编号
									f = true;
									
									//判断自行车有没有被借出
									if(status[i] == 2) {
										//被借出
										
										//判断该自行车是否是该用户借的
										if(root.equals(person[i])) {
											//是该用户借的
											System.out.println(d + "借出时间:" + date[i]);
											System.out.println("归还时间:" + nowTime());
											
											System.out.print("正在计算时间差，请稍等");
											
											//装逼用的
											try {
												for(int j = 0; j < 5; j++) {
													Thread.sleep(1000);
													System.out.print(".");
												}
												System.out.println();
											}catch(Exception e) {
												e.printStackTrace();
											}
											
											//计算出多少个小时
											int diff = (int)(difference(date[i], nowTime())/1000/60/60);
											//是否剩余出来多少个小时
											int hour = diff % 24;
											//多少天
											int day = (diff-hour)/24;
											
											if(day == 0) {
												//不满一天
												System.out.println("时间差为：" + hour + "小时");
												System.out.println("每小时0.16元计算" + hour + "小时您应付" + (hour*0.16) + "元");
												
												//把状态恢复到未租赁
												status[i] = 1;
												person[i] = "未租赁";
												date[i] = nowTime();
												payback[i] = null;
												break;
												
											}else {
												//超过一天
												System.out.println("时间差为：" + day + "天" + hour + "小时");
												System.out.println("40块钱一天，不满一天按每小时0.16元计算"+ day + "天" + hour + "小时您应付" + (hour*0.16+day*40) + "元");
												
												//把状态恢复到未租赁
												status[i] = 1;
												person[i] = "未租赁";
												date[i] = nowTime();
												payback[i] = null;
												break;
											}
											
										}else {
											//不是该用户借的
											System.out.println("大哥，这车不是你借的啊！");
											break;
										}
										
									}else {
										//没有被借出
										System.out.println("此自行车没有被借出");
										break;
									}
									
								}
							}
							
							if(!f) {
								System.out.println("没有您要归还的自行车编号！请输入2查询确认信息");
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
					System.out.println("大哥，你登录啊！");
				}
				quit();
				
			}else if(option.equals("6")) {
				//退出系统
				String confirm;
				
				while(true) {
					System.out.println("是否确认退出系统?(y/n)");
					confirm = input.next();
					
					if(confirm.equals("y")) {
						System.out.println("欢迎下次使用！");
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
				//登录系统
				
				//注销
				root = "";
				login = false;
				exist = false;
				
				while(true) {	//防止用户输入账号密码错误
					System.out.println(line2);
					System.out.println(">>欢迎进入登录系统");
					System.out.println(line2);
					
					System.out.print("请输入您的用户名：");
					entername = input.next();
					System.out.print("请输入您的密码：");
					enterpwd = input.next();
					
					for(int i = 0; i < username.length; i++) {
						
						//循环查看有没有对应的数据
						if(entername.equals(username[i])) {
							exist = true;
							if(enterpwd.equals(pwd[i].toString())) {
								root = username[i];
								login = true;
								break;
								
							}else {
								System.out.println("密码错误，请重新输入");
							}
							
						}
						
					}
					
					if(!exist) {
						//当用户还没有注册
						
						System.out.println("您还未注册，请您先注册再登录！");
						System.out.println(line2);
						
						boolean f = false;
						
						for(int i = 0; i < username.length; i++) {
							
							if(username[i] == null) {
								System.out.print("您的账号：");
								username[i] = input.next();
								System.out.print("您的密码：");
								pwd[i] = input.next();
								System.out.println(line2);
								System.out.println("您的账户注册成功！");
								System.out.println("账号为：" + username[i]);
								System.out.println("密码为：" + pwd[i]);
								System.out.println("请牢记您的资料，目前系统已经为您自动登录。");
								
								root = username[i];
								login = true;
								
								f = true;
								System.out.println(line2);
								quit();
								break;
							}
						}
						
						if(f == false) {
							System.out.println("抱歉，用户已经爆满");
						}
						
						break;	//跳出循环
					}else {
						break;
						
					}
				}	
			}else {
				System.out.println("没有这个选项，请重新选择");
			}
		}
		
	}
	
	public static int quit() {
		int num;
		Scanner input = new Scanner(System.in);
		
		while(true) {
			//防止用户输入不是0
			System.out.print("请输入0返回主菜单");
			num = input.nextInt();
			
			if(num == 0) {
				break;	//为0，跳出
			}
		}
		
		return num;
	}
	
	//计算时间差(单位：毫秒)
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
