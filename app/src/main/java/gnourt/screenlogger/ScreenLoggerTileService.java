package gnourt.screenlogger;

import android.content.ComponentCallbacks;
import android.service.quicksettings.TileService;
import android.service.quicksettings.Tile;
import android.graphics.drawable.Icon;

public class ScreenLoggerTileService extends TileService {

    private boolean _started = false;
    @Override
    public void onClick() {
        super.onClick();
        this.toggle();
    }

    @Override
    public void onStartListening() {
        super.onStartListening();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void start(){
        if(this._started==true)return;
        this._started = true;
        Tile tile= this.getQsTile();
        tile.setIcon(Icon.createWithResource(this, R.drawable.ic_recording_on));
        tile.setState(Tile.STATE_ACTIVE);
        tile.updateTile();

    }
    public  void stop(){
        if(this._started==false)return;
        this._started = false;
        Tile tile= this.getQsTile();
        tile.setIcon(Icon.createWithResource(this, R.drawable.ic_recording_off));
        tile.setState(Tile.STATE_INACTIVE);
        tile.updateTile();
    }
    public  void toggle(){
        if(this._started==true){
            this.stop();
        }else{
            this.start();
        }
    }

}
