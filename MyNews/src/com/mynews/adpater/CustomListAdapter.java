package com.mynews.adpater;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.mynews.activity.R;
import com.mynews.app.AppController;
import com.mynews.model.News;

public class CustomListAdapter extends BaseAdapter {
	private Context context;
	private LayoutInflater inflater;
	private List<News> newsItems;
	ImageLoader imageLoader = AppController.getInstance().getImageLoader();

	public CustomListAdapter(Activity activity, List<News> newsItems) {
		this.context = activity;
		this.newsItems = newsItems;
	}

	@Override
	public int getCount() {
		return newsItems.size();
	}

	@Override
	public Object getItem(int location) {
		return newsItems.get(location);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (inflater == null)
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (convertView == null)
			convertView = inflater.inflate(R.layout.list_row, null);

		if (imageLoader == null)
			imageLoader = AppController.getInstance().getImageLoader();
		//get user pic 
		NetworkImageView userpic = (NetworkImageView) convertView
				.findViewById(R.id.userPic);
		
		//get user name object from view
		TextView username = (TextView) convertView.findViewById(R.id.userName);
		
		//get news gist object from view
		TextView newsgist = (TextView) convertView.findViewById(R.id.newsGist);
		
		ImageView img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
		ImageView audio_icon = (ImageView) convertView.findViewById(R.id.audio_icon);
		ImageView video_icon = (ImageView) convertView.findViewById(R.id.video_icon);

		// getting movie data for the row
		News nwsobj = newsItems.get(position);

		// userpic image
		userpic.setImageUrl(nwsobj.getUserPic(), imageLoader);
		
		// user name
		username.setText(nwsobj.getUsername());
		
		// newsgist
		newsgist.setText(String.valueOf(nwsobj.getNewsgist()));
		
	// if json data does not contain any of these then hide them from UI
		if(!nwsobj.getNewsimg()){
			img_icon.setVisibility(View.GONE);
		}
		if(!nwsobj.getNewsaudio()){
			audio_icon.setVisibility(View.GONE);
		}
		if(!nwsobj.getNewsvideo()){
			video_icon.setVisibility(View.GONE);
		}
		
		return convertView;
	}

}