package com.example.tuprak_01; // Sesuaikan jika berbeda

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvName, tvHeadline;

    private final ActivityResultLauncher<Intent> editProfileLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    String newName = result.getData().getStringExtra("EXTRA_NAME");
                    String newHeadline = result.getData().getStringExtra("EXTRA_HEADLINE");

                    // Memperbarui tampilan profil
                    if (newName != null) tvName.setText(newName);
                    if (newHeadline != null) tvHeadline.setText(newHeadline);
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Menghubungkan variabel dengan ID di XML
        tvName = findViewById(R.id.tv_name);
        tvHeadline = findViewById(R.id.tv_headline);
        Button btnEditProfile = findViewById(R.id.btn_edit_profile);

        // Aksi ketika tombol ditekan
        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditProfileActivity.class);
                intent.putExtra("CURRENT_NAME", tvName.getText().toString());
                intent.putExtra("CURRENT_HEADLINE", tvHeadline.getText().toString());

                // Menjalankan Intent
                editProfileLauncher.launch(intent);
            }
        });
    }
}