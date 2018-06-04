package model.elements.mobile;

import java.io.IOException;

public class HeroAnim implements Runnable{
	
	private Hero hero;
	
	HeroAnim(Hero hero)
	{
		this.hero = hero;
	}
	
	public void run()
	{
		while (true)
		{
			switch (this.hero.getDirection())
			{
			case UP :
				try {
					this.hero.setSprite("lorann_up.png");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case NOP :
				switch (this.hero.getSprite().getImageName())
				{
				case "lorann_l.png" :
					try {
						this.hero.setSprite("lorann_ul.png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "lorann_ul.png" :
					try {
						this.hero.setSprite("lorann_u.png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "lorann_u.png" :
					try {
						this.hero.setSprite("lorann_ur.png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "lorann_ur.png" :
					try {
						this.hero.setSprite("lorann_r.png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "lorann_r.png" :
					try {
						this.hero.setSprite("lorann_br.png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "lorann_br.png" :
					try {
						this.hero.setSprite("lorann_b.png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "lorann_b.png" :
					try {
						this.hero.setSprite("lorann_bl.png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "lorann_bl.png" :
					try {
						this.hero.setSprite("lorann_l.png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					
				}
				break;
			default :
				break;
			}
		
		}
		
		}

	}


