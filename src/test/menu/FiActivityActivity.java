package test.menu;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.IOnAreaTouchListener;
import org.andengine.entity.scene.ITouchArea;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;
import org.andengine.entity.sprite.Sprite;

import org.andengine.entity.util.FPSLogger;

import org.andengine.input.touch.TouchEvent;

import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import org.andengine.opengl.font.IFont;
import android.content.Intent;
//import android.util.Log;
//import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;




public class FiActivityActivity extends SimpleBaseGameActivity  {
	
	private static final int CAMERA_WIDTH = 240;
	private static final int CAMERA_HEIGHT = 320;

	
	
	protected Camera mCamera;

	protected Scene mMainScene;

	
	Button alert;
	protected MenuScene mMenuScene;
	private TextureRegion mGrassBackground;
	private BitmapTextureAtlas mMenuTexture;
	protected ITextureRegion mMenuStartTextureRegion;
	protected ITextureRegion mMenuStart1TextureRegion;
	protected ITextureRegion mMenuOptionTextureRegion;
	protected ITextureRegion mMenuOption1TextureRegion;
	protected ITextureRegion mMenuQuitTextureRegion;
	protected ITextureRegion mMenuQuit1TextureRegion;
	protected boolean firman;
	IFont mFont;
	
//	private Sound button_menu;
	
	public EngineOptions onCreateEngineOptions() {
		this.mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);

		return new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED, new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), this.mCamera);
		
		
	}
	
	
	@Override
	protected void onCreateResources() {
   BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		
			
		this.mMenuTexture = new BitmapTextureAtlas(this.getTextureManager(), 2048, 2048, TextureOptions.BILINEAR);
		this.mMenuStartTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mMenuTexture, this, "Mulai.png",400,400);
		this.mMenuStart1TextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mMenuTexture, this, "Mulai1.png",300,300);
		this.mMenuOptionTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mMenuTexture, this, "option.png", 600, 600);
		this.mMenuOption1TextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mMenuTexture, this, "option1.png", 500, 500);
		this.mMenuQuitTextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mMenuTexture, this, "Keluar.png", 800,800);
		this.mMenuQuit1TextureRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mMenuTexture, this, "Keluar1.png", 700,700);
		this.mGrassBackground = BitmapTextureAtlasTextureRegionFactory.createFromAsset(this.mMenuTexture, this, "fun1.jpg", 0, 0);
		this.mMenuTexture.load();

//		SoundFactory.setAssetBasePath("mfx/");
//
//			try {
//				this.button_menu = SoundFactory.createSoundFromAsset(this.mEngine.getSoundManager(), this, "sound-menu.wap");
//			} catch (IllegalStateException e) {
//				 e.printStackTrace();
//			
//				
//	} catch (final IOException e) {
//		Debug.e(e);
//		}
//			
			
	}

	@Override
	protected Scene onCreateScene() {
	
	this.mEngine.registerUpdateHandler(new FPSLogger());


	
	mMainScene = new Scene();
	
	Sprite bgSprite = new Sprite(0, 0, mGrassBackground, getVertexBufferObjectManager());
	mMainScene.attachChild(bgSprite);
	final ButtonSprite bgSprite1 = new ButtonSprite(75,10,mMenuStartTextureRegion,mMenuStart1TextureRegion, getVertexBufferObjectManager());
	mMainScene.attachChild(bgSprite1);
	final ButtonSprite bgSprite2 = new ButtonSprite(75,40,mMenuOptionTextureRegion,mMenuOption1TextureRegion, getVertexBufferObjectManager());
	mMainScene.attachChild(bgSprite2);
	final ButtonSprite bgSprite3 = new ButtonSprite(75,70,mMenuQuitTextureRegion,mMenuQuit1TextureRegion, getVertexBufferObjectManager());
	mMainScene.attachChild(bgSprite3);
	
	bgSprite1.setOnClickListener(new OnClickListener()
	{
		
		public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX,
				float pTouchAreaLocalY) {
			 
			
 				
		if((ButtonSprite) pButtonSprite == bgSprite1) {
				 firman= true;				
				 start();
				 
				 
			 }
			
		
		}
	});
	
	bgSprite2.setOnClickListener(new OnClickListener() {
		
		public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX,
				float pTouchAreaLocalY) {
			
			
			 if((ButtonSprite) pButtonSprite == bgSprite2) {
				 firman= true;				
				start();
				 
				 
			 }
			
		}
	});
	
	bgSprite3.setOnClickListener(new OnClickListener() {
		
		public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX,
				float pTouchAreaLocalY) {
			
			 if((ButtonSprite) pButtonSprite == bgSprite3) {
				 firman= true;				
				sa(alert);
				}
		}
	});
	
	
	
	
	
	mMainScene.registerTouchArea(bgSprite1);
	mMainScene.registerTouchArea(bgSprite2);
	mMainScene.registerTouchArea(bgSprite3);
	mMainScene.registerTouchArea(bgSprite);
	mMainScene.setOnAreaTouchListener(new IOnAreaTouchListener() {
		public boolean onAreaTouched(TouchEvent pSceneTouchEvent,
				ITouchArea pTouchArea, float pTouchAreaLocalX,
				float pTouchAreaLocalY) {
			
			
//			if(pSceneTouchEvent.isActionDown())
//            {
//                
//                	  FiActivityActivity.this.button_menu.play();
//                          
//                 
//               }
//			
			// TODO Auto-generazted method stub
			return true;
		}
	});
	

	


	
	return mMainScene;
	}
	
	protected void start(){
		
		
		 final int welcomeScreenDisplay = 2000;
		        Thread welcomeThread = new Thread() {
		            int wait = 0;
		            @Override
		            public void run() {
		                try {
		                    super.run();
		                    while (wait < welcomeScreenDisplay) {
		                        sleep(100);
		                        wait += 100;
		                    }
		                } catch (Exception e) {
		                    System.out.println("EXc=" + e);
		                } finally {
		                    startActivity(new Intent("test.menu.FiActivityActivity.cekok"));
		                    finish();
		                }
		            }
		        };
		        welcomeThread.start();
	
 	
	}
	public void sa(View v) {
	      System.exit(0);
	   }
	


	}



