package nyc.bbah.mvp_retro.main_activity;

import java.util.ArrayList;

import nyc.bbah.mvp_retro.model.Notice;

public interface MainContract {

    /**
     * Call when user interact with the view and when view OnDestroy()
     * */
    interface presenter{

        void onDestroy();

        void onRefreshButtonClick();

        void requestDataFromServer();
    }
    /**
     * showProgress() and hideProgress() would be used for displaying and hiding the progressBar
     * while the setDataToRecyclerView and onResponseFailure is fetched from the GetNoticeInteractorImpl class
     **/
    interface MainView{

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(ArrayList<Notice> noticeArrayList);

        void onResponseFailure(Throwable throwable);

    }
    /**
     * Intractors are classes built for fetching data from your database, web services, or any other data source.
     **/
    interface GetNoticeInteractor {

        void getNoticeArrayList(OnFinishedListener onFinishedListener);

        interface OnFinishedListener{
            void onFinished(ArrayList<Notice> noticeArrayList);
            void onFailure(Throwable t);
        }
    }
}
