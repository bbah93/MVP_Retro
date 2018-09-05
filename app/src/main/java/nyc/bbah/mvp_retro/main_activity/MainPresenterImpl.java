package nyc.bbah.mvp_retro.main_activity;

import java.util.ArrayList;

import nyc.bbah.mvp_retro.model.Notice;

public class MainPresenterImpl implements MainContract.presenter, MainContract.GetNoticeInteractor.OnFinishedListener {



    @Override
    public void onDestroy() {

    }

    @Override
    public void onRefreshButtonClick() {

    }

    @Override
    public void requestDataFromServer() {

    }

    @Override
    public void onFinished(ArrayList<Notice> noticeArrayList) {

    }

    @Override
    public void onFailure(Throwable t) {

    }
}
