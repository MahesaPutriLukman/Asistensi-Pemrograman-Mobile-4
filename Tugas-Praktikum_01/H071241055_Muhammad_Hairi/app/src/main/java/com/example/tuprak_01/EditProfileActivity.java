package com.example.tuprak_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        EditText etName = findViewById(R.id.et_edit_name);
        EditText etHeadline = findViewById(R.id.et_edit_headline);
        Button btnSave = findViewById(R.id.btn_save);

        // Menampilkan data lama di kolom input
        Intent currentIntent = getIntent();
        if (currentIntent != null) {
            etName.setText(currentIntent.getStringExtra("CURRENT_NAME"));
            etHeadline.setText(currentIntent.getStringExtra("CURRENT_HEADLINE"));
        }

        // Aksi ketika tombol simpan ditekan
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mengambil teks baru yang diketik pengguna
                String updatedName = etName.getText().toString();
                String updatedHeadline = etHeadline.getText().toString();

                // Membuat Intent kembalian berisi data baru
                Intent resultIntent = new Intent();
                resultIntent.putExtra("EXTRA_NAME", updatedName);
                resultIntent.putExtra("EXTRA_HEADLINE", updatedHeadline);

                // Mengeset status "OK" dan mengirim data
                setResult(RESULT_OK, resultIntent);

                // Menutup halaman EditProfileActivity
                finish();
            }
        });
    }
}