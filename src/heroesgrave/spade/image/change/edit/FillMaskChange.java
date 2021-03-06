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

package heroesgrave.spade.image.change.edit;

import heroesgrave.spade.image.RawImage;
import heroesgrave.spade.image.RawImage.MaskMode;
import heroesgrave.spade.image.change.IEditChange;
import heroesgrave.spade.image.change.IMaskChange;
import heroesgrave.spade.io.Serialised;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class FillMaskChange implements IEditChange, IMaskChange, Serialised
{
	private MaskMode mode;
	
	public FillMaskChange()
	{
		
	}
	
	public FillMaskChange(MaskMode mode)
	{
		this.mode = mode;
	}
	
	@Override
	public void apply(RawImage image)
	{
		image.setMaskEnabled(true);
		image.fillMask(mode);
	}
	
	@Override
	public FillMaskChange encode()
	{
		return this;
	}
	
	@Override
	public FillMaskChange decode()
	{
		return this;
	}
	
	@Override
	public void write(DataOutputStream out) throws IOException
	{
		out.writeInt(mode.ordinal());
	}
	
	@Override
	public void read(DataInputStream in) throws IOException
	{
		int mode = in.readInt();
		for(MaskMode m : MaskMode.values())
		{
			if(m.ordinal() == mode)
			{
				this.mode = m;
				break;
			}
		}
	}
}
