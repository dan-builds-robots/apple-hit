package daniel.mygdx.applehit.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;

import sun.rmi.runtime.Log;

public class AppleHit extends ApplicationAdapter {

	SpriteBatch batch;

	Texture apple;

	Texture rubberDuck;

	Texture flippedRubberDuck;

	Texture knife;

	Texture pauseButton;

	Texture playButton;

	Texture goldenApple;

	Texture settingsButton;

	Texture settingsMenu;

	Texture shopIcon;

	Rectangle knifeRectangle;

	Rectangle appleRectangle;

	Rectangle duckOneRectangle;

	Rectangle duckTwoRectangle;

	Rectangle duckThreeRectangle;

	Rectangle duckFourRectangle;

	Rectangle duckFiveRectangle;



	Texture gameOverText;

	int midHorizontal;

	int appleWidth;

	int appleHeight;

	int screenHeight;

	int knifeWidth;

	int knifeHeight;

	double scaleFactor;

	int rubberDuckWidth;

	int rubberDuckHeight;

	int knifeMovementUpwards;

	int knifeSpeed;

	int knifeWaitTime;

	int gameState;

	boolean knifeIsAtTopOfScreen;

	double duckOneSpeed;

    double duckTwoSpeed;

    double duckThreeSpeed;

    double duckFourSpeed;

    double duckFiveSpeed;

    int duckOneXPosition;

    int duckTwoXPosition;

    int duckThreeXPosition;

    int duckFourXPosition;

    int duckFiveXPosition;

    boolean duckOneIsOffScreen;

    boolean duckTwoIsOffScreen;

    boolean duckThreeIsOffScreen;

    boolean duckFourIsOffScreen;

    boolean duckFiveIsOffScreen;

    int screenWidth;

    int pauseHeight;

	int pauseWidth;

	int playHeight;

	int playWidth;

	int score;

	int highScore;

	BitmapFont font;

	int timer;

	boolean timerStarted;

	boolean projectileLaunched;

	int scoreTextSize;

	int gameOverTextSize;

	int gameOverTextWidth;

	int gameOverTextHeight;

	int pointsPerHit;

	int numHitsBeforeGold;

	int numHits;

	boolean goldApple;

	Music gameMusic;

	Music appleHit;

	Music appleHit2;

	Music goldAppleHit;

	Music duckShot;

	Music duckSound;

	Music duckSound2;

	Music buttonTap;

	Random rand;

	int randNumber;

	int duckSoundCount;

	int randNumber2;

	int duckSoundCount2;

	boolean duckHitSoundPlayed;

	Preferences prefs;

	boolean speedIncrease;

	private Stage stage;

	Skin mySkin;

    ImageButton playImageButton;

    ImageButton settingsImageButton;

    ImageButton shopImageButton;

    ImageButton pauseBtn;

	GlyphLayout highScoreLayout;

	int highScoreTextSize;

	int shopIconHeight;

	int shopIconWidth;

	int settingsPanelHeight;

	int settingsPanelWidth;

	OrthographicCamera camera;

	Viewport viewport;

	FreeTypeFontGenerator generator;

	FreeTypeFontGenerator.FreeTypeFontParameter parameter;

	FreeTypeFontGenerator generatorLight;

	FreeTypeFontGenerator.FreeTypeFontParameter parameterLight;

	BitmapFont gameFont;

	BitmapFont fontLight;

	boolean fourDucks;

	boolean paused;

	Texture black;

	Sprite blackSpr;

	Float blackOpacity;

	int pauseBtnCooldownTimer;

	int initialPauseTap;

	Texture xTexture;

	Texture signature;

	Texture sfx;

	Texture music;

	Texture home;

	Boolean settingsPanelOpen;

	ImageButton homeBtn;

	ImageButton musicBtn;

	ImageButton sfxBtn;

	Boolean musicMuted;

	Boolean sfxMuted;

	Actor x;


	@Override
	public void create () {

		batch = new SpriteBatch();

		FreeTypeFontGenerator.setMaxTextureSize(3000);

		apple = new Texture("apple.png");

		rubberDuck = new Texture("rubber_duck.png");

		flippedRubberDuck = new Texture("flipped_rubber_duck.png");

		knife = new Texture("knife.png");

		pauseButton = new Texture("pause_button.png");

		playButton = new Texture("play_button.png");

		gameOverText = new Texture("game_over.png");

		goldenApple = new Texture ("gold_apple2.png");

		settingsButton = new Texture ("metal-gear.png");

		shopIcon = new Texture ("supermarket2.png");

		settingsMenu = new Texture("settings_menu.png");

		black = new Texture("black.png");

		xTexture = new Texture("x.png");

		signature = new Texture("signature.png");

		home = new Texture("home.png");

		sfx = new Texture("sfx.png");

		music = new Texture("music.png");

		blackSpr = new Sprite(black);

		blackOpacity = 0f;

		scaleFactor = 2.5;

		screenHeight = 1794;

		//screenHeight = Gdx.graphics.getHeight();

		screenWidth = 1080;

		midHorizontal = screenWidth / 2;

		appleWidth = (int) (200);

		appleHeight = (int) (appleWidth);

		//screenWidth = Gdx.graphics.getWidth();

		//knifeWidth = (int) ((Gdx.graphics.getWidth() / 5.2 ) / (scaleFactor * 1.2));

		//knifeHeight = (int) ((Gdx.graphics.getHeight() / 1.457) / (scaleFactor * 1.2));

		knifeHeight = (int) (appleHeight * 1.255859375);

		knifeWidth = (int) (knifeHeight * 0.2799377916);

		rubberDuckWidth = (int) ((screenWidth / 2) / scaleFactor);

		rubberDuckHeight = (int) (rubberDuckWidth);

		pauseHeight = (int) (pauseButton.getHeight() / (scaleFactor * 1.5));

		pauseWidth = (int) (pauseButton.getWidth() / (scaleFactor * 1.5));

        playHeight = (int) ((screenHeight / 5) / (scaleFactor * .8));

		playWidth = (int) (playHeight * 1.76446281);

		knifeMovementUpwards = 0;

		knifeSpeed = 40;

		knifeWaitTime = 3;

		gameState = 0;

		duckOneSpeed = 2.75;

		duckTwoSpeed = 3;

		duckThreeSpeed = 3.75;

		duckFourSpeed = 4;

		duckFiveSpeed = 4.25;

		duckOneXPosition = 0;

		duckTwoXPosition = (int)(0 - flippedRubberDuck.getWidth() * .9);

		duckThreeXPosition = 0;

		duckFourXPosition = 0;

		font = new BitmapFont();

		font.setColor(Color.WHITE);

		font.getData().setScale(10);

		generator = new FreeTypeFontGenerator(Gdx.files.internal("gameplay.ttf"));

		generatorLight = new FreeTypeFontGenerator(Gdx.files.internal("gameplay.ttf"));

		parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

		parameterLight = new FreeTypeFontGenerator.FreeTypeFontParameter();

		//fontLight = new BitmapFont();

		parameter.size = 500;

		parameterLight.size = 500;

		gameFont = generator.generateFont(parameter);

		fontLight = generatorLight.generateFont(parameterLight);

		generator.dispose();

		timer = 30;

		timerStarted = false;

		projectileLaunched = false;

		scoreTextSize = (int) screenWidth / 108;

		gameOverTextSize = (int) (screenWidth / 108 / 2);

		gameOverTextHeight = (int) (screenHeight / 1.77799 / scaleFactor);

		gameOverTextWidth = (int) (gameOverTextHeight * 1.40797);

		settingsPanelHeight = settingsMenu.getHeight();

        settingsPanelWidth = settingsMenu.getWidth();

		pointsPerHit = 5;

		numHitsBeforeGold = 5;

		numHits = 0;

		goldApple = false;

		gameMusic = Gdx.audio.newMusic(Gdx.files.internal("fluffing_a_duck.ogg"));

		gameMusic.setVolume(.7f);

		gameMusic.setLooping(true);

		gameMusic.play();

		appleHit = Gdx.audio.newMusic(Gdx.files.internal("apple_hit_sfx.wav"));

		appleHit2 = Gdx.audio.newMusic(Gdx.files.internal("apple_hit_sfx.wav"));

		goldAppleHit = Gdx.audio.newMusic(Gdx.files.internal("gold_apple_hit_sfx.wav"));

		duckShot = Gdx.audio.newMusic(Gdx.files.internal("duck_shot_sfx.wav"));

		duckSound = Gdx.audio.newMusic(Gdx.files.internal("duck_sound.wav"));

		duckSound2 = Gdx.audio.newMusic(Gdx.files.internal("duck_sound.wav"));

		buttonTap = Gdx.audio.newMusic(Gdx.files.internal("button_tap.wav"));

		rand = new Random();

		randNumber = rand.nextInt(150) + 10;

		duckSoundCount = 0;

		duckSoundCount2 = 0;

		duckHitSoundPlayed = false;

		randNumber2 = rand.nextInt(200) + 100;

		prefs = Gdx.app.getPreferences("My Preferences");

		highScore = prefs.getInteger("high score", 0);

		highScoreLayout = new GlyphLayout();

		speedIncrease = false;

		shopIconHeight = (int)(shopIcon.getHeight() / 4);

		shopIconWidth = (int)(shopIcon.getWidth() / 4);


        Drawable playButtonDrawable = new TextureRegionDrawable(new TextureRegion(playButton));

        playImageButton = new ImageButton(playButtonDrawable);

        playImageButton.setSize(playWidth, playHeight);

        playImageButton.setPosition((screenWidth / 2) - (playWidth / 2), (screenHeight / 2) - playWidth / 2);



		Drawable settingsDrawable = new TextureRegionDrawable(new TextureRegion(settingsButton));

		settingsImageButton = new ImageButton(settingsDrawable);

		settingsImageButton.setSize(shopIconWidth, shopIconHeight);

		settingsImageButton.setPosition((int)(shopIconWidth * .2), (int)(shopIconHeight * .2));


		Drawable shopDrawable = new TextureRegionDrawable(new TextureRegion(shopIcon));

		shopImageButton = new ImageButton(shopDrawable);

		shopImageButton.setSize(shopIconWidth, shopIconHeight);

		shopImageButton.setPosition((int)((screenWidth) - (shopIconWidth * 1.2)), (int)(shopIconHeight * .2));


		Drawable homeDrawable = new TextureRegionDrawable(new TextureRegion(home));

		homeBtn = new ImageButton(homeDrawable);

		homeBtn.setSize((int)(home.getWidth() * .65), (int)(home.getHeight() * .65));

		homeBtn.setPosition((int)(screenWidth / 2 - home.getWidth() * .65 / 2) - 300, (int)(screenHeight - home.getHeight() * .65) / 2);


		Drawable musicDrawable = new TextureRegionDrawable(new TextureRegion(music));

		musicBtn = new ImageButton(musicDrawable);

		musicBtn.setSize((int)(music.getWidth() * .65), (int)(music.getHeight() * .65));

		musicBtn.setPosition((int)(screenWidth / 2 - music.getWidth() * .65 / 2), (int)(screenHeight - music.getHeight() * .65) / 2);


		Drawable sfxDrawable = new TextureRegionDrawable(new TextureRegion(sfx));

		sfxBtn = new ImageButton(sfxDrawable);

		sfxBtn.setSize((int)(sfx.getWidth() * .65), (int)(sfx.getHeight() * .65));

		sfxBtn.setPosition((int)(screenWidth / 2 - sfx.getWidth() * .65 / 2) + 300, (int)(screenHeight - sfx.getHeight() * .65) / 2);


		Drawable pauseBtnDrawable = new TextureRegionDrawable(new TextureRegion(pauseButton));

		pauseBtn = new ImageButton(pauseBtnDrawable);

		pauseBtn.setSize((int)(pauseButton.getWidth() * .4), (int)(pauseButton.getWidth() *.4));

		pauseBtn.setPosition((int)(screenWidth * (1 - .05)) - (int)(pauseButton.getWidth() * .4), (int) ((screenHeight) - (int)(pauseButton.getWidth() *.4) - 30 - (screenWidth * .025)));


		camera = new OrthographicCamera();

		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);

		viewport = new StretchViewport(1080, 1794, camera);

		stage = new Stage(viewport, batch); //Set up a stage for the ui

		stage.setViewport(viewport);

		stage.getViewport().update(screenWidth, screenHeight);

        stage.addActor(playImageButton); //Add the button to the stage to perform rendering and take input.

		stage.addActor(shopImageButton);

		stage.addActor(pauseBtn);

		stage.addActor(settingsImageButton);

		stage.addActor(homeBtn);

		stage.addActor(musicBtn);

		stage.addActor(sfxBtn);

		x = new Actor();

		stage.addActor(x);

        Gdx.input.setInputProcessor(stage);

		viewport.apply();

		stage.getViewport().apply();

		stage.act();

		highScoreTextSize = (int)(screenHeight / 468.5);

		fourDucks = false;

		paused = false;

		pauseBtnCooldownTimer = 20;

		initialPauseTap = 0;

		settingsPanelOpen = false;

		sfxMuted = false;

		musicMuted = false;

	}

	@Override

	public void render () {

		camera.update();

		stage.getCamera().update();

		Gdx.gl.glClearColor(0, 2, 30, 1);

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);

		stage.getBatch().setProjectionMatrix(camera.combined);

		settingsImageButton.setVisible(false);

		batch.begin();

		stage.act(Gdx.graphics.getDeltaTime());

		batch.draw(knife, midHorizontal - knifeWidth / 2, (int) (knifeHeight * .1) + knifeMovementUpwards, knifeWidth, knifeHeight);

		//stage.act();


		if (numHits % numHitsBeforeGold == 0 && numHits != 0) {

			batch.draw(goldenApple, (int) (midHorizontal - (appleWidth * 1.5) / 2), screenHeight - ((int)(appleHeight * 1.5)) - 8, (int) (appleWidth * 1.5), (int)(appleHeight * 1.5));

			goldApple = true;

		} else {

			batch.draw(apple, midHorizontal - appleWidth / 2, screenHeight - ((int)(appleHeight * 1.3)), appleWidth, appleHeight);

		}

		if (gameState == 0) {

			pauseBtn.setVisible(false);

			homeBtn.setVisible(false);

			musicBtn.setVisible(false);

			sfxBtn.setVisible(false);

			shopImageButton.setVisible(false);

			gameFont.getData().setScale(.08f);

			gameFont.setColor(Color.WHITE);

			highScoreLayout.setText(gameFont, "High score: " + highScore);

			gameFont.draw(batch, highScoreLayout, (screenWidth / 2) - (highScoreLayout.width / 2), (int)(screenHeight / 2 + playHeight * .5));


			//Game not yet started, launch screen

			playImageButton.addListener(new InputListener() {

                @Override

				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {

                	buttonTap.play();

					settingsImageButton.setVisible(false);

					shopImageButton.setVisible(false);

                    gameState = 1;

                    playImageButton.setVisible(false);

                    pauseBtn.setVisible(true);

					return true;

                }

                @Override

				public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

				}

            });



			settingsImageButton.addListener(new InputListener() {

				@Override

				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {

					Gdx.app.log("This","is getting run  multiple freaking tiems");

					buttonTap.play();

					settingsPanelOpen = true;

					return true;

				}

				@Override

				public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

				}

			});

			shopImageButton.addListener(new InputListener() {

				@Override

				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {

					buttonTap.play();

					shopImageButton.setVisible(false);

					return true;

				}

				@Override

				public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

				}

			});

			if (settingsPanelOpen) {

				playImageButton.setVisible(false);

				batch.draw(settingsMenu, (screenWidth - (int)(settingsMenu.getWidth() * .65)) / 2, (int)(screenHeight - settingsMenu.getHeight() * .65) / 2, (int)(settingsMenu.getWidth() * .65), (int)(settingsMenu.getHeight() * .65));

				homeBtn.setVisible(true);

				musicBtn.setVisible(true);

				sfxBtn.setVisible(true);

				musicBtn.setPosition((int)(screenWidth / 2 - music.getWidth() * .65 / 2), (int)(screenHeight - music.getHeight() * .65) / 2);


				if (musicMuted) {
//
					batch.draw(xTexture, (int)(screenWidth / 2 - x.getWidth() * .65 / 2), (int)((screenHeight - music.getHeight() * .65) / 2), (int)x.getWidth(), (int)x.getHeight());

					gameMusic.pause();

				}

				if (sfxMuted) {

					batch.draw(xTexture, (int)(screenWidth / 2 - music.getWidth() * .65 / 2) + 300, (int)((screenHeight - music.getHeight() * .65) / 2), (int)x.getWidth(), (int)x.getHeight());

					buttonTap.setVolume(0);

					appleHit.setVolume(0);

					appleHit2.setVolume(0);

					goldAppleHit.setVolume(0);

					duckShot.setVolume(0);

					duckSound.setVolume(0);

					duckSound2.setVolume(0);

					duckShot.setVolume(0);

				}

			} else {

				homeBtn.setVisible(false);

				musicBtn.setVisible(false);

				sfxBtn.setVisible(false);

				playImageButton.setVisible(true);

			}

			homeBtn.addListener(new InputListener() {

				@Override

				public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

					buttonTap.play();

					settingsPanelOpen = false;

					return true;

				}

				@Override

				public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

				}

			});

			if (Gdx.input.justTouched()) {

				Gdx.app.log("Just touched", "true");

			}


			musicBtn.addListener(new InputListener() {

				@Override

				public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

					buttonTap.play();

					if (musicMuted) {

						musicMuted = false;

						gameMusic.play();

					} else {

						musicMuted = true;

					}

					return true;

				}

				@Override

				public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

				}

			});

			sfxBtn.addListener(new InputListener() {

				@Override

				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {

					if (sfxMuted && Gdx.input.justTouched()) {

						sfxMuted = false;

						buttonTap.setVolume(1);

						appleHit.setVolume(1);

						appleHit2.setVolume(1);

						goldAppleHit.setVolume(1);

						duckShot.setVolume(1);

						duckSound.setVolume(1);

						duckSound2.setVolume(1);

						duckShot.setVolume(1);

						buttonTap.play();

					} else if (Gdx.input.justTouched()) {

						buttonTap.setVolume(0);

						appleHit.setVolume(0);

						appleHit2.setVolume(0);

						goldAppleHit.setVolume(0);

						duckShot.setVolume(0);

						duckSound.setVolume(0);

						duckSound2.setVolume(0);

						duckShot.setVolume(0);

						sfxMuted = true;

					}

					return true;

				}

				@Override

				public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

				}

				public void touchDragged(InputEvent event, float x, float y, int pointer) {

				}

			});

        } else if (gameState == 1) {

		    //Game in action

            //batch.draw(pauseButton, (int) (screenWidth * .025), (int) ((screenHeight) - pauseHeight - (screenWidth * .025)), pauseWidth, pauseHeight);

            if (!fourDucks) {

				batch.draw(rubberDuck, screenWidth - duckOneXPosition, (int)(screenHeight / 1.5), (int)(rubberDuckWidth * .9), (int)(rubberDuckHeight * .9));

				batch.draw(flippedRubberDuck, duckTwoXPosition, (int)(screenHeight / 2.1), (int)(rubberDuckWidth * .9), (int)(rubberDuckHeight * .9));

				batch.draw(rubberDuck, screenWidth - duckThreeXPosition, (int)(screenHeight / 3.5), (int)(rubberDuckWidth * .9), (int)(rubberDuckHeight * .9));

			} else {

				batch.draw(rubberDuck, screenWidth - duckOneXPosition, (int)(1260), (int)(rubberDuckWidth * .7), (int)(rubberDuckHeight * .7));

				batch.draw(flippedRubberDuck, duckTwoXPosition, (int)(995), (int)(rubberDuckWidth * .7), (int)(rubberDuckHeight * .7));

				batch.draw(rubberDuck, screenWidth - duckThreeXPosition, (int)(730), (int)(rubberDuckWidth * .7), (int)(rubberDuckHeight * .7));

				batch.draw(flippedRubberDuck, duckFourXPosition, (int)(465), (int)(rubberDuckWidth * .7), (int)(rubberDuckHeight * .7));

			}

			if (score >= 75) {

            	fourDucks = true;

			}


            if (score < 100) {

				gameFont.getData().setScale(.25f);

			} else if (score < 1000) {

				gameFont.getData().setScale(.2f);

			} else if (score < 1000) {

				gameFont.getData().setScale(.15f);

			} else if (score < 10000) {

				gameFont.getData().setScale(.1f);

			}

			gameFont.setColor(Color.WHITE);

			gameFont.draw(batch, "" + score, (int) (screenWidth * .05), (int) (screenHeight * (1-.025) - 30));

			if (!paused) {

				duckOneXPosition += duckOneSpeed;

				duckTwoXPosition += duckTwoSpeed;

				duckThreeXPosition += duckThreeSpeed;

				if (fourDucks) {

					duckFourXPosition += duckFourSpeed;

				}

			}
			if (pauseBtn.isPressed()) {

				buttonTap.play();

				if (paused && pauseBtnCooldownTimer >= 20) {

					paused = false;

				} else if (pauseBtnCooldownTimer >= 20) {


					paused = true;

				}

				pauseBtnCooldownTimer = 0;

				Gdx.app.log("pauseBtnCooldownTimer",pauseBtnCooldownTimer + "");

			}
//
			pauseBtnCooldownTimer ++;



			if (!paused) {

				duckSoundCount++;

				duckSoundCount2++;

			}

            if (duckSoundCount >= randNumber && !paused) {

				duckSound.play();

				randNumber = rand.nextInt(150) + 50;

				duckSoundCount = 0;

			}

			if (duckSoundCount2 >= randNumber2 && !paused) {

				duckSound2.play();

				randNumber2 = rand.nextInt(150) + 50;

				duckSoundCount2 = 0;

			}

            if (Gdx.input.justTouched() && !paused) {

            	duckOneSpeed += 0.02;

            	duckTwoSpeed += 0.02;

            	duckThreeSpeed += 0.02;

            	duckFourSpeed += 0.02;

            	duckFiveSpeed += 0.02;

			}


            if (Gdx.input.justTouched() && !paused && pauseBtnCooldownTimer >= 10) {

            	Gdx.app.log("pauseBthCooldownTimer1",pauseBtnCooldownTimer+"");

                projectileLaunched = true;

            }


            if (projectileLaunched && !knifeIsAtTopOfScreen && !paused) {

                knifeMovementUpwards += knifeSpeed;

            } else if (!paused) {

                projectileLaunched = false;

                knifeMovementUpwards = 0;

            }
//
//			pauseBtn.addListener(new ClickListener() {
//
//				@Override
//
//				public void clicked(InputEvent event, float x, float y) {
//
//					buttonTap.play();
//
//					if (paused && pauseBtnCooldownTimer >= 20) {
//
//						paused = false;
//
//						pauseBtnCooldownTimer = 0;
//
//					} else if (pauseBtnCooldownTimer >= 20) {
//
//						paused = true;
//
//						pauseBtnCooldownTimer = 0;
//
//						initialPauseTap = 0;
//
//					}
//
//				}
//
//			});


			if (paused) {

				blackOpacity = .5f;

				blackSpr.draw(batch, blackOpacity);

				pauseBtn.setSize(pauseButton.getWidth(),pauseButton.getWidth());

				pauseBtn.setPosition((screenWidth - pauseBtn.getWidth()) / 2,(screenHeight - pauseBtn.getHeight()) / 2);

				pauseBtn.draw(batch,1);

			} else {

				pauseBtn.setSize((int)(pauseButton.getWidth() * .4), (int)(pauseButton.getWidth() *.4));

				pauseBtn.setPosition((int)(screenWidth * (1 - .05)) - (int)(pauseButton.getWidth() * .4), (int) ((screenHeight) - (int)(pauseButton.getWidth() *.4) - 30 - (screenWidth * .025)));

			}


        } else if (gameState == 3) {

		    //Game over

           if (score > highScore) {

				prefs.putInteger("high score", score);

				prefs.flush();

				highScore = prefs.getInteger("high score", 0);

				Gdx.app.log("High Score", "" + highScore);

				Gdx.app.log("Score", "" + score);

			}

			//Draw the ducks

			if (!fourDucks) {

				batch.draw(rubberDuck, screenWidth - duckOneXPosition, (int)(screenHeight / 1.5), (int)(rubberDuckWidth * .9), (int)(rubberDuckHeight * .9));

				batch.draw(flippedRubberDuck, duckTwoXPosition, (int)(screenHeight / 2.1), (int)(rubberDuckWidth * .9), (int)(rubberDuckHeight * .9));

				batch.draw(rubberDuck, screenWidth - duckThreeXPosition, (int)(screenHeight / 3.5), (int)(rubberDuckWidth * .9), (int)(rubberDuckHeight * .9));

			} else {

				batch.draw(rubberDuck, screenWidth - duckOneXPosition, (int)(1260), (int)(rubberDuckWidth * .7), (int)(rubberDuckHeight * .7));

				batch.draw(flippedRubberDuck, duckTwoXPosition, (int)(995), (int)(rubberDuckWidth * .7), (int)(rubberDuckHeight * .7));

				batch.draw(rubberDuck, screenWidth - duckThreeXPosition, (int)(730), (int)(rubberDuckWidth * .7), (int)(rubberDuckHeight * .7));

				batch.draw(flippedRubberDuck, duckFourXPosition, (int)(465), (int)(rubberDuckWidth * .7), (int)(rubberDuckHeight * .7));

			}
            //Display the score

			if (score < 100) {

				gameFont.getData().setScale(.25f);

			} else if (score < 1000) {

				gameFont.getData().setScale(.2f);

			} else if (score < 1000) {

				gameFont.getData().setScale(.15f);

			} else if (score < 10000) {

				gameFont.getData().setScale(.1f);

			}

			gameFont.setColor(Color.WHITE);

			gameFont.draw(batch, "" + score, (int) (screenWidth * .05), (int) (screenHeight * (1-.025) - 30));

            gameFont.getData().setScale(.28f);

			highScoreLayout.setText(gameFont, "Game Over");

			gameFont.draw(batch, highScoreLayout, (screenWidth / 2) - (highScoreLayout.width / 2), (int)(screenHeight / 2 + gameOverTextHeight * .485));


			gameFont.setColor(Color.GOLD);

			gameFont.getData().setScale(.1f);

			highScoreLayout.setText(gameFont, "Score: " + score);

			gameFont.draw(batch, highScoreLayout, (screenWidth / 2) - (highScoreLayout.width / 2), (int)(screenHeight / 2 + gameOverTextHeight * .7));

			if (Gdx.input.justTouched()) {

				duckOneXPosition = 0;

				duckTwoXPosition = 0;

				duckThreeXPosition = 0;

				duckFourXPosition = 0;

				duckFiveXPosition = 0;

				score = 0;

				gameState = 0;

				knifeMovementUpwards = 0;

				numHits = 0;

				duckOneSpeed = 2.75;

				duckTwoSpeed = 3;

				duckThreeSpeed = 3.75;

				duckFourSpeed = 4;

				duckFiveSpeed = 4.25;

				fourDucks = false;

				duckHitSoundPlayed = false;

				playImageButton.setVisible(true);

				//shopImageButton.setVisible(true);

				//settingsImageButton.setVisible(true);

				pauseBtn.setVisible(false);

				paused = false;

				pauseBtnCooldownTimer = 29;
			}

        }


        knifeRectangle = new Rectangle(midHorizontal - knifeWidth / 2, (int) ((knifeHeight * .1) + knifeMovementUpwards), (int) (knifeWidth * .8), (int)(knifeHeight * .9));

        if (!fourDucks) {

			duckOneRectangle = new Rectangle(screenWidth - duckOneXPosition, (int)(screenHeight / 1.5), (int) (rubberDuckWidth * .8), rubberDuckHeight);

			duckTwoRectangle = new Rectangle(duckTwoXPosition, (int)(screenHeight / 2.1), (int) (rubberDuckWidth * .8), rubberDuckHeight);

			duckThreeRectangle = new Rectangle (screenWidth - duckThreeXPosition, (int)(screenHeight / 3.5), (int) (rubberDuckWidth * .8), rubberDuckHeight);

		}

        if (fourDucks) {

			duckOneRectangle = new Rectangle(screenWidth - duckOneXPosition, (int)(1260), (int) (int)(rubberDuckWidth * .7 * .8), (int)(rubberDuckHeight * .7));

			duckTwoRectangle = new Rectangle(duckTwoXPosition, (int)(995), (int)(rubberDuckWidth * .7 * .8), (int)(rubberDuckHeight * .7));

			duckThreeRectangle = new Rectangle (screenWidth - duckThreeXPosition, (int)(730), (int)(rubberDuckWidth * .7 * .8), (int)(rubberDuckHeight * .7));

			duckFourRectangle = new Rectangle (duckFourXPosition, (int)(465), (int)(rubberDuckWidth * .7 * .8), (int)(rubberDuckHeight * .7));

//batch.draw(flippedRubberDuck, duckFourXPosition, (int)(465), (int)(rubberDuckWidth * .7), (int)(rubberDuckHeight * .7));
		}

        if (true/*fiveDucks*/) {

			duckFiveRectangle = new Rectangle (screenWidth - duckFiveXPosition, (int)(screenHeight / 3.5), (int) (rubberDuckWidth * .8), rubberDuckHeight);

		}

		appleRectangle = new Rectangle(midHorizontal - appleWidth / 2, screenHeight - ((int)(appleHeight * 1.3)), appleWidth, appleHeight);

		knifeIsAtTopOfScreen = (((int) ((knifeHeight) / 3) + knifeMovementUpwards) > screenHeight - ((int)(appleHeight * 1.3)) - knifeHeight / 2);

		duckOneIsOffScreen = ((duckOneXPosition - rubberDuckWidth) > screenWidth * (1.2));

        duckTwoIsOffScreen = (duckTwoXPosition > screenWidth * 1.2);

        duckThreeIsOffScreen = ((duckThreeXPosition - rubberDuckWidth) > screenWidth * 1.2);

        duckFourIsOffScreen = (duckFourXPosition > screenWidth * 1.2);

        duckFiveIsOffScreen = ((duckFiveXPosition - rubberDuckWidth) > screenWidth * 1.2);

        if (duckOneIsOffScreen) {

            duckOneXPosition = 0;

        }

        if (duckTwoIsOffScreen) {

            duckTwoXPosition = rubberDuckWidth * -1;

        }

        if (duckThreeIsOffScreen) {

            duckThreeXPosition = 0;

        }

        if (duckFourIsOffScreen) {

        	duckFourXPosition = rubberDuckWidth * -1;

		}


		if (duckFiveIsOffScreen) {

			duckFiveXPosition = 0;

		}

		if (Intersector.overlaps(knifeRectangle, duckOneRectangle)) {

			gameState = 3;

			if (!duckHitSoundPlayed) {

				duckShot.play();

				duckHitSoundPlayed = true;

			}

		}

		if (Intersector.overlaps(knifeRectangle, duckTwoRectangle)) {

			gameState = 3;

			if (!duckHitSoundPlayed) {

				duckShot.play();

				duckHitSoundPlayed = true;

			}

		}

		if (Intersector.overlaps(knifeRectangle, duckThreeRectangle)) {

			gameState = 3;

			if (!duckHitSoundPlayed) {

				duckShot.play();

				duckHitSoundPlayed = true;

			}

		}

		if (fourDucks) {

			if (Intersector.overlaps(knifeRectangle, duckFourRectangle)) {

				gameState = 3;

				if (!duckHitSoundPlayed) {

					duckShot.play();

					duckHitSoundPlayed = true;

				}

			}

		}

		if (Intersector.overlaps(knifeRectangle, appleRectangle) && timer >= 10 && gameState == 1) {

			timerStarted = true;

			timer = 0;

			if (!goldApple) {

				score += pointsPerHit;

				if (appleHit.isPlaying()) {

					appleHit2.play();

				} else {

					appleHit.play();

				}

			} else {

				score += (pointsPerHit * 3);

				goldApple = false;

				goldAppleHit.play();

			}

			numHits++;

		}

		if (timerStarted) {

			timer++;

		}

		batch.end();

		stage.draw();

	}
	
	@Override

	public void dispose () {

		batch.dispose();

		stage.dispose();

	}

	@Override

	public void resize(int width, int height) {

//		int WIDTH = Gdx.graphics.getWidth();
//
//		int HEIGHT = Gdx.graphics.getHeight();
//
//		float scale = (float) 1794 / (float) HEIGHT;
//
//		WIDTH = (int) (WIDTH  * scale);
//
//		HEIGHT = (int) (HEIGHT  * scale);
//
//		viewport.update(width, height);
//
//		camera = new OrthographicCamera(WIDTH, HEIGHT);

		viewport.update(width, height);

		stage.getViewport().update(width, height, true);

		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);

		stage.getCamera().position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);

		//camera.position.set(camera.viewportWidth / 2,camera.viewportHeight / 2,0);

	}

}
