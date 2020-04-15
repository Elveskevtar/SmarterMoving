// ==================================================================
// This file is part of Smart Render.
//
// Smart Render is free software: you can redistribute it and/or
// modify it under the terms of the GNU General Public License as
// published by the Free Software Foundation, either version 3 of the
// License, or (at your option) any later version.
//
// Smart Render is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with Smart Render. If not, see <http://www.gnu.org/licenses/>.
// ==================================================================

package net.smart.moving.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;

public class SmartModelSpecialRenderer extends SmartModelRotationRenderer {
	
	public boolean doPopPush;

	public SmartModelSpecialRenderer(ModelBase modelBase, int i, int j, SmartModelRotationRenderer baseRenderer) {
		super(modelBase, i, j, baseRenderer);
		ignoreRender = true;
	}

	public void beforeRender(boolean popPush) {
		doPopPush = popPush;
		ignoreRender = false;
	}

	@Override
	public void doRender(float f, boolean useParentTransformations) {
		if (doPopPush) {
			GL11.glPopMatrix();
			GL11.glPushMatrix();
		}
		super.doRender(f, true);
	}

	public void afterRender() {
		ignoreRender = true;
		doPopPush = false;
	}
}
