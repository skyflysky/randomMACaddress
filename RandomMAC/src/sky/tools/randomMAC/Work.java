package sky.tools.randomMAC;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.Random;

public class Work
{
	public static void main(String[] args)
	{
		Random random = new Random(seedGen());
		StringBuffer sb = new StringBuffer(hexGen(random));
		for(int i = 0 ; i < 5 ; i++)
		{
			sb.append("-");
			sb.append(hexGen(random));
		}
		Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable s = new StringSelection(sb.toString());
		sysClip.setContents(s, null);
		System.out.println("运行完成，生成新的MAC地址为：" + sb.toString());
		return;
	}
	
	private static String hexGen(Random random)
	{
		String result = Integer.toHexString(random.nextInt(255));
		if(result.length() == 1)
		{
			result = 0 + result;
		}
		return result.toUpperCase();
	}
	
	/**
	 * 随机数种子生成
	 * @return
	 */
	private static long seedGen()
	{
		long ll = System.currentTimeMillis();
		try
		{
			Thread.sleep(new Long(String.valueOf(ll % 191)));
		} 
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		long l = System.currentTimeMillis();
		Long l1 = new Long(String.valueOf(l % 49009));
		Long l2 = new Long(String.valueOf(l % 37813));
		Long l3 = new Long(String.valueOf(l % 24137));
		Long l4 = new Long(String.valueOf(l % 18371));
		return ll + l1 - l2 + l3 - l4;
	}
	
}
