package nyc.bbah.mvp_retro.main_activity;

import java.util.ArrayList;

import nyc.bbah.mvp_retro.model.Notice;

public class MainPresenterImpl implements MainContract.presenter, MainContract.GetNoticeInteractor.OnFinishedListener {

    private MainContract.MainView mainView;
    private MainContract.GetNoticeInteractor getNoticeIntractor;

    public MainPresenterImpl(MainContract.MainView mainView, MainContract.GetNoticeInteractor getNoticeIntractor){
            this.mainView = mainView;
            this.getNoticeIntractor = getNoticeIntractor;
    }

    @Override
    public void onDestroy() {
            mainView = null;
    }

    @Override
    public void onRefreshButtonClick() {
        if(mainView != null){
            mainView.showProgress();
        }
         getNoticeIntractor.getNoticeArrayList(this);
    }

    @Override
    public void requestDataFromServer() {
            getNoticeIntractor.getNoticeArrayList(this);
    }

    @Override
    public void onFinished(ArrayList<Notice> noticeArrayList) {
            if (mainView != null){
                mainView.setDataToRecyclerView(noticeArrayList);
                mainView.hideProgress();
            }
    }

    @Override
    public void onFailure(Throwable t) {
            if (mainView != null){
                mainView.onResponseFailure(t);
                mainView.hideProgress();
            }
    }
}
