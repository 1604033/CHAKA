package com.example.sibbir.cyclesharingapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class showpath extends AppCompatActivity {
    int rider, biker;
    TextView textView;
    String path;
    int INFINITY = 99999;
    ListView listView;
    ArrayList<String>location=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showpath);

        textView = findViewById(R.id.textView);
        String a=getIntent().getStringExtra("rider");
        String b=getIntent().getStringExtra("biker");


        rider = Integer.parseInt(a);
        biker = Integer.parseInt(b);
        listView=findViewById(R.id.listview);






        InitializeGraph();



           showListView();








        //path = "kisu ekta aslo..."
        //textView.setText(path);


    }

    private void InitializeGraph (){
        // TODO code application logic here
        //Scanner obj = new Scanner(System.in);
        int i, j, p, q;
        int[][] G = new int[45][45];
        for (i = 0; i < 45; i++) {
            for (j = 0; j < 45; j++) {
                G[i][j] = 0;
            }
        }
        String[] location_name = {"Cuet_main_gate", "Shaheed_minar", "Medical_Center", "Padma_Pukur", "canteen", "Basketball_ground", "Shadhinota_cottor", "TSC", "Central_Mosque", "Power_plant", "Central_Field", "Sheikh_rasel_hall", "QK_hall_junction", "QK_hall", "Tarek_Huda_hall_junction", "Tarek_Huda_hall", "S_and_N_hall_office", "Shah_hall", "Bangobondhu_hall_pond", "Bangobondhu_hall", "SK_hall", "Samsunnahar_hall", "vc_resident", "EME_building", "Workshop", "new_library", "Civil_building", "Old_library", "Old_Admistration _building", "Pre_engineering_building", "Vc_building", "Sonali_bank", "South_hall_extention", "Bangobandhu_hall_extention", "PME_building", "Auditorium", "Arch_and_Planning_building", "Earthquake_institute", "Canteen_3", "New_academic_building", "Cuet_school", "Dormitory_pond", "Dormitory", "Residential_Area", "Pocket_gate"};
        G[0][1] = 1;
        G[1][0] = 1;
        G[1][2] = 1;
        G[2][1] = 1;
        G[2][3] = 1;
        G[3][2] = 1;
        G[3][4] = 3;
        G[4][3] = 3;
        G[4][5] = 2;
        G[5][4] = 2;
        G[5][6] = 1;
        G[6][5] = 1;
        G[6][7] = 1;
        G[7][6] = 1;
        G[7][8] = 1;
        G[8][7] = 1;
        G[8][9] = 2;
        G[9][8] = 2;
        G[9][10] = 1;
        G[10][9] = 1;
        G[10][11] = 1;
        G[11][10] = 1;
        G[11][12] = 2;
        G[12][11] = 2;
        G[12][8] = 1;
        G[8][12] = 1;
        G[12][13] = 2;
        G[13][12] = 2;
        G[12][14] = 1;
        G[14][12] = 1;
        G[14][6] = 2;
        G[6][14] = 2;
        G[14][15] = 2;
        G[15][14] = 2;
        G[14][17] = 2;
        G[17][14] = 2;
        G[15][16] = 1;
        G[16][15] = 1;
        G[17][18] = 2;
        G[18][17] = 2;
        G[18][4] = 3;
        G[4][18] = 3;
        G[18][19] = 3;
        G[19][18] = 3;
        G[20][9] = 2;
        G[9][20] = 2;
        G[20][21] = 1;
        G[21][20] = 1;
        G[21][22] = 3;
        G[22][21] = 3;
        G[21][23] = 2;
        G[23][21] = 2;
        G[23][24] = 1;
        G[24][23] = 1;
        G[23][39] = 2;
        G[39][23] = 2;
        G[24][25] = 1;
        G[25][24] = 1;
        G[24][39] = 2;
        G[39][24] = 2;
        G[25][26] = 1;
        G[26][25] = 1;
        G[25][37] = 2;
        G[37][25] = 2;
        G[26][27] = 1;
        G[27][26] = 1;
        G[27][28] = 1;
        G[28][27] = 1;
        G[27][35] = 2;
        G[35][27] = 2;
        G[28][29] = 1;
        G[29][28] = 1;
        G[29][30] = 1;
        G[30][29] = 1;
        G[30][6] = 1;
        G[6][30] = 1;
        G[31][0] = 2;
        G[0][31] = 2;
        G[31][32] = 1;
        G[32][31] = 1;
        G[32][33] = 1;
        G[33][32] = 1;
        G[33][34] = 6;
        G[34][33] = 6;
        G[34][35] = 6;
        G[35][34] = 6;
        G[35][36] = 2;
        G[36][35] = 2;
        G[36][37] = 2;
        G[37][36] = 2;
        G[37][38] = 2;
        G[38][37] = 2;
        G[37][39] = 3;
        G[39][37] = 3;
        G[40][11] = 2;
        G[11][40] = 2;
        G[40][41] = 1;
        G[41][40] = 1;
        G[41][42] = 1;
        G[42][41] = 1;
        G[42][43] = 2;
        G[43][42] = 2;
        G[43][44] = 2;
        G[44][43] = 2;
        G[43][9] = 6;
        G[9][43] = 6;
        location_track(G, rider, biker, location_name);

    }
    private void showListView(){
        ArrayAdapter adapter=new ArrayAdapter(showpath.this,android.R.layout.simple_list_item_1,location);
        listView.setAdapter(adapter);
    }


    void location_track(int G[][], int startvertex, int q, String location_name[]) {

        int[][] value = new int[45][45];
        int[] dstnc = new int[45];
        int[] path = new int[45];
        int[] coloured = new int[45];
        int count, shortest_value, nextvertex = 0, i, j;
        for (i = 0; i < 45; i++) {
            for (j = 0; j < 45; j++) {
                if (G[i][j] == 0) {
                    value[i][j] = INFINITY;
                } else {
                    value[i][j] = G[i][j];
                }
            }
        }

        for (i = 0; i < 45; i++) {
            dstnc[i] = value[startvertex][i];
            path[i] = startvertex;
            coloured[i] = 0;
        }

        dstnc[startvertex] = 0;
        coloured[startvertex] = 1;
        count = 1;

        while (count < 45 - 1) {
            shortest_value = INFINITY;

            for (i = 0; i < 45; i++) {
                if (coloured[i]==0 && dstnc[i] < shortest_value) {
                    shortest_value = dstnc[i];
                    nextvertex = i;
                }
            }

            coloured[nextvertex] =1;
            for (i = 0; i < 45; i++) {
                if (coloured[i]==0) {
                    if (shortest_value + value[nextvertex][i] < dstnc[i]) {
                        dstnc[i] = shortest_value + value[nextvertex][i];
                        path[i] = nextvertex;
                    }
                }
            }
            count++;
        }

        i = q;
        int serial=1;

        //System.out.println( location_name[i]);
        location.add(serial+"->>"+location_name[i]);

        j = i;
        do {
            serial++;
            j = path[j];
            //System.out.println(serial+"<-" + location_name[j]);
            location.add(serial+"->>" +location_name[j]);

        } while (j != startvertex);
    }
}