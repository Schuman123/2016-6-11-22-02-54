package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bizhidemo.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import bean.TypeBean;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Schuman on 2016/6/11.
 */
public class TypeAdapter extends BaseAdapter {

    @Bind(R.id.iv_show)
    ImageView ivShow;
    @Bind(R.id.tv_type)
    TextView tvType;
    @Bind(R.id.tv_typename)
    TextView tvTypename;
    private List<TypeBean> list = new ArrayList<>();
    private LayoutInflater inflater;
    private ImageLoader loader;

    public TypeAdapter(Context context, List<TypeBean> list,ImageLoader loader) {
        this.list = list;
        inflater = LayoutInflater.from(context);
        this.loader = loader;
    }

    @Override
    public int getCount() {
        return list != null ? list.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_type_list, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();

        }
        //通过holder取出控件设置显示内容

        //通过ImageLoader对象调用displayImage方法设置iv_show显示的内容
//        loader.displayImage(url,ivShow);





        return convertView;
    }


    static class ViewHolder {
        @Bind(R.id.iv_show)
        ImageView ivShow;
        @Bind(R.id.tv_type)
        TextView tvType;
        @Bind(R.id.tv_typename)
        TextView tvTypename;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
