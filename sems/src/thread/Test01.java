package thread;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Test01 extends Frame{
	
	
	public Test01() {
	 this.addWindowListener(new WindowAdapter() {
		 @Override
		public void windowClosing(WindowEvent e) {
			 System.exit(0);
		}
	});
  }
	
		
	public static void main(String[] args) {
		Test01 t1 = new Test01();
		t1.setSize(300, 400);
		t1.setVisible(true);
		
		Thread t = Thread.currentThread();
		System.out.println("현재 스레드: " + t.getName());
	  
		ThreadGroup tgMain = t.getThreadGroup();
		System.out.println("main의 스레드 그룹:" + tgMain.getName());
		
		ThreadGroup tgSystem = tgMain.getParent();
		System.out.println("main 스레드그룹의 상위" + tgSystem.getName());
		
		//ThreadGroup tg3 = tg2.getParent();
		//System.out.println("main 스레드그룹의 상위" + tg3.getName());
		printSubThreadGroup(tgSystem, "system/");
		printSubThread(tgSystem, "system/");
		
		printSubThreadGroup(tgMain, "system/main/");
		printSubThread(tgMain, "system/main/");
		
  }
	
	
	private static void printSubThreadGroup(ThreadGroup tg, String path) {
	//system 스레드그룹에 하위 스레드그룹
			ThreadGroup[] tglist = new ThreadGroup[10];
			int size = tg.enumerate(tglist, false);
			
			for(int i=0;i<size;i++){
				System.out.println(path + tglist[i].getName());
			}
  }
	
	
	static private void printSubThread(ThreadGroup tg, String path){
	//system 스레드그룹의 하위 스레드:
			Thread[] tlist = new Thread[10];
			int size = tg.enumerate(tlist, false);
			
			for(int i=0;i<size;i++){
				System.out.println("system/(t):" + tlist[i].getName());
			}
	}
}
