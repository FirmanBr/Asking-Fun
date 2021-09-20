package test.menu;



import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.util.FPSLogger;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.color.Color;
import org.andengine.entity.scene.background.Background;





public class cekok extends SimpleBaseGameActivity {
	
	public static int CAM_WIDTH = 240;
	public static int CAM_HEIGTH = 320;

	Scene mScene;
	Camera mCamera;
	
	public EngineOptions onCreateEngineOptions() {
		// TODO Auto-generated method stub
		mCamera = new Camera(20, 30, CAM_WIDTH, CAM_HEIGTH);
		return new EngineOptions(true, ScreenOrientation.PORTRAIT_FIXED, new RatioResolutionPolicy(CAM_WIDTH, CAM_HEIGTH), mCamera);
//		return null;
	}
	
	
	
	
	
	
	
	@Override
	protected void onCreateResources() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Scene onCreateScene() {
		
      mEngine.registerUpdateHandler(new FPSLogger());
		
		mScene = new Scene();
		mScene.setBackground(new Background(Color.YELLOW));
		mScene.setBackgroundEnabled(true);

        return mScene;
	}
	
	
	
       
}