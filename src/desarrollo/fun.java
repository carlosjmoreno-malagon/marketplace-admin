package desarrollo;


import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class fun extends JPanel{

	fun()
	{
		
		GridLayout layout = new GridLayout(10,1);
		layout.setVgap(5);
		
		this.setLayout(layout);
		this.setPreferredSize(new Dimension(400,560));
		
	}
	
	public void updateNumbers()
	{
		Component[] listItems = this.getComponents();
		
		for(int i = 0;i<listItems.length;i++)
		{
			if(listItems[i] instanceof productos)
			{
				((productos)listItems[i]).changeIndex(i+1);
			}
		}
		
	}
	
	public void removeCompletedTasks()
	{
		
		for(Component c : getComponents())
		{
			if(c instanceof productos)
			{
				if(((productos)c).getState())
				{
					remove(c);
					updateNumbers();
				}
			}
		}
		
	}
}