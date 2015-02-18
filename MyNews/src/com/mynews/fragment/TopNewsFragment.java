/**
 * 
 */
package com.mynews.fragment;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.mynews.activity.R;
import com.mynews.adpater.CustomListAdapter;
import com.mynews.app.AppController;
import com.mynews.model.News;

/**
 * @author kuatre
 *
 */
public class TopNewsFragment extends Fragment {
	// News json url
	private static final String ipaddress	=	"192.168.1.145";
	private static final String url = "http://"+ipaddress+":8080/mynewwebservice/rest/mynews/news/top";
	private ProgressDialog pDialog;
	private List<News> newsList = new ArrayList<News>();
	private ListView listView;
	private CustomListAdapter adapter;
	
	private Activity activity;
	
	/**
	 * @param activity
	 */
	public TopNewsFragment(Activity activity) {
		this.activity = activity;
	}

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.topnews, container, false);
        
        listView = (ListView)rootView.findViewById(R.id.list);
		adapter = new CustomListAdapter(getActivity(), newsList);
		listView.setAdapter(adapter);
		listView.setAdapter(adapter);

		pDialog = new ProgressDialog(getActivity());
		// Showing progress dialog before making http request
		pDialog.setMessage("Loading...");
		pDialog.show();

		// changing action bar color
		activity.getActionBar().setBackgroundDrawable(
				new ColorDrawable(Color.parseColor("#1b1b1b")));

		// Creating volley request obj
		JsonArrayRequest movieReq = new JsonArrayRequest(url,
				new Response.Listener<JSONArray>() {
					@Override
					public void onResponse(JSONArray response) {
						hidePDialog();
						// Parsing json
						System.out.println("KKK response... "+response.length());
						System.out.println("KKK response... "+response);
						for (int i = 0; i < response.length(); i++) {
							try {
								JSONObject obj = response.getJSONObject(i);
								News news = new News();
								news.setUsername(obj.getString("username"));
								news.setUserPic("http://"+ipaddress+":8080/mynewwebservice/reporters_images/"+obj.getString("userPic"));
								news.setNewsgist(obj.getString("newsgist"));
								news.setNewsimg(obj.getBoolean("newsimg"));
								news.setNewsaudio(obj.getBoolean("newsaudio"));
								news.setNewsvideo(obj.getBoolean("newsvideo"));
								news.setTimeofnews(obj.getString("timeofnews"));
								newsList.add(news);

							} catch (JSONException e) {
								e.printStackTrace();
							}

						}

						// notifying list adapter about data changes
						// so that it renders the list view with updated data
						adapter.notifyDataSetChanged();
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						hidePDialog();

					}
				});

		// Adding request to request queue
		AppController.getInstance().addToRequestQueue(movieReq);
        
         
        return rootView;
    }
	
	private void hidePDialog() {
		if (pDialog != null) {
			pDialog.dismiss();
			pDialog = null;
		}
	}
}
