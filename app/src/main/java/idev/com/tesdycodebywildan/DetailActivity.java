package idev.com.tesdycodebywildan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private TextView nama, tglLahir, desc;
    private ImageView image;
    private ModelArtis modelArtis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        nama = findViewById(R.id.txtNamaArtis);
        tglLahir = findViewById(R.id.txtTanggalLahir);
        desc = findViewById(R.id.txtDesc);
        image = findViewById(R.id.gambarArtis);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            modelArtis = bundle.getParcelable("data");
            getSupportActionBar().setTitle(modelArtis.getName());
            nama.setText(modelArtis.getName());
            tglLahir.setText(Utils.dateFormatter(modelArtis.getDob()));
            desc.setText(modelArtis.getDescription());
            Picasso.with(this).load(modelArtis.getImage()).into(image);
        }
    }
}
