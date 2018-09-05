package nyc.bbah.mvp_retro.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.bbah.mvp_retro.R;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {
    TextView txtNoticeTitle, txtNoticeBrief, txtNoticeFilePath;

    public EmployeeViewHolder(View itemView) {
        super(itemView);

        txtNoticeTitle =  itemView.findViewById(R.id.txt_notice_title);
        txtNoticeBrief =  itemView.findViewById(R.id.txt_notice_brief);
        txtNoticeFilePath =  itemView.findViewById(R.id.txt_notice_file_path);
    }


}
