// {LICENSE}
/*
 * Copyright 2013-2014 HeroesGrave and other Spade developers.
 * 
 * This file is part of Spade
 * 
 * Spade is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package heroesgrave.spade.gui.menus;

import heroesgrave.spade.image.Document;
import heroesgrave.spade.main.Spade;
import heroesgrave.utils.io.IOUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import com.alee.laf.menu.WebMenuItem;

@SuppressWarnings("serial")
public class DocumentMenuItem extends WebMenuItem implements ActionListener
{
	public Document doc;
	
	public DocumentMenuItem(Document doc)
	{
		super("Untitled");
		this.doc = doc;
		this.addActionListener(this);
		checkName();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Spade.setDocument(doc);
	}
	
	public void checkName()
	{
		File f = doc.getFile();
		String s;
		if(f != null)
		{
			s = IOUtils.relativeFrom(new File(System.getProperty("user.dir")), f);
		}
		else
		{
			s = "Untitled";
		}
		this.setText(s);
	}
}
