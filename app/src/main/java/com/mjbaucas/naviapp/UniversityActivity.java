package com.mjbaucas.naviapp;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UniversityActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university);

        Button backBtn = findViewById(R.id.back_university);
        String selCountry = getIntent().getStringExtra("SELECTED_COUNTRY");
        final Button selectBtn = findViewById(R.id.select_university);

        final RadioGroup uniGrp = findViewById(R.id.rgrp_university);

        List<String> universities = getUniversities(selCountry);
        for(int i = 0; i < universities.size(); i++){
            RadioButton tempBtn = new RadioButton(getApplicationContext());
            tempBtn.setText(universities.get(i));
            tempBtn.setTextColor(Color.BLACK);
            uniGrp.addView(tempBtn);
        }

        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = uniGrp.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    Toast.makeText(UniversityActivity.this, "No university selected", Toast.LENGTH_LONG).show();
                } else {
                    RadioButton uniBtn = findViewById(selectedId);
                    String university = uniBtn.getText().toString();
                    Uri uri = Uri.parse("geo:0,0?q=" + Uri.encode(findUniversity(university)));
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public List<String> getUniversities(String country){
        List<String> universities = new ArrayList<>();

        switch(country){
            case "Egypt":
                universities.add("Al-Azhar University");
                universities.add("University of Cairo");
                return universities;
            case "Uganda":
                universities.add("Makerere University");
                universities.add("Kampala International University");
                return universities;
            case "Ghana":
                universities.add("University of Ghana");
                universities.add("University of Cape Coast");
                return universities;
            case "Kenya":
                universities.add("University of Nairobi");
                universities.add("Mt.Kenya University");
                return universities;
            case "Philippines":
                universities.add("University of Baguio");
                universities.add("Saint Louis University");
                return universities;
            case "Malaysia":
                universities.add("University of Malaya");
                universities.add("Sunway University");
                return universities;
            case "Japan":
                universities.add("University of Tokyo");
                universities.add("Nihon University");
                return universities;
            case "Singapore":
                universities.add("National University of Singapore");
                universities.add("Nanyang Technological University");
                return universities;
            case "Great Britain":
                universities.add("University of Oxford");
                universities.add("University of Cambridge");
                return universities;
            case "Belgium":
                universities.add("Ghent University");
                universities.add("KU Leuven");
                return universities;
            case "Switzerland":
                universities.add("University of Zurich");
                universities.add("University of Geneva");
                return universities;
            case "Germany":
                universities.add("Technical University of Munich");
                universities.add("Humboldt University of Berlin");
                return universities;
            case "Australia":
                universities.add("University of Melbourne");
                universities.add("University of Sydney");
                return universities;
            case "New Zealand":
                universities.add("University of Auckland");
                universities.add("University of Otago");
                return universities;
            case "Papua New Guinea":
                universities.add("University of Papua New Guinea");
                universities.add("Divide Word University");
                return universities;
            case "Fiji":
                universities.add("University of South Pacific");
                universities.add("University of Fiji");
                return universities;
            default:
                universities.add("University of Guelph");
                universities.add("University of Waterloo");
                universities.add("University of British Columbia");
                return universities;
        }
    }

    public String findUniversity (String university){
        switch(university){
            case "Al-Azhar University":
                return "https://www.google.ca/maps/place/Al+Azhar+University/@30.0576399,31.3151336,15z/data=!4m5!3m4!1s0x0:0x3605b36368106b0e!8m2!3d30.0576399!4d31.3151336";
            case "University of Cairo":
                return "https://www.google.ca/maps/place/Cairo+University/@30.0227517,31.2072362,21z/data=!4m5!3m4!1s0x0:0xbd9781bf40115c5d!8m2!3d30.0227646!4d31.2073201";
            case "Makerere University":
                return "https://www.google.ca/maps/place/Makerere+University/@0.3304882,32.56975,17.88z/data=!4m5!3m4!1s0x177dbb6d88e54def:0xddc6fcfbe10b089d!8m2!3d0.329183!4d32.5709881";
            case "Kampala International University":
                return "https://www.google.ca/maps/place/Kampala+International+University/@0.2942346,32.6050793,17.88z/data=!4m5!3m4!1s0x177dbc4773e5b495:0x96f5cb21a235f61c!8m2!3d0.2946511!4d32.6050213";
            case "University of Ghana":
                return "https://www.google.ca/maps/place/University+of+Ghana,+Legon/@5.6515805,-0.1975074,17.08z/data=!4m5!3m4!1s0x0:0xd78257e67498c1a0!8m2!3d5.650562!4d-0.1962244";
            case "University of Cape Coast":
                return "https://www.google.ca/maps/place/University+Of+Cape+Coast/@5.1037528,-1.2830015,19.08z/data=!4m5!3m4!1s0xfddfed6fc798569:0x7531c2a02fe48636!8m2!3d5.103506!4d-1.282483";
            case "University of Nairobi":
                return "https://www.google.ca/maps/place/University+of+Nairobi/@-1.2802264,36.8161048,19.12z/data=!4m5!3m4!1s0x0:0x193d4e2017527761!8m2!3d-1.2803586!4d36.8162641";
            case "Mt.Kenya University":
                return "https://www.google.ca/maps/place/Mount+Kenya+University/@-1.0463567,37.0837702,18z/data=!4m5!3m4!1s0x182f4ef517d2dd15:0x8e7d07383daf5916!8m2!3d-1.0465364!4d37.0851757";
            case "University of Baguio":
                return "https://www.google.ca/maps/place/University+Of+Baguio/@16.4144989,120.5964554,17.08z/data=!4m5!3m4!1s0x0:0xe282b2015f6debba!8m2!3d16.4155598!4d120.5974703";
            case "Saint Louis University":
                return "https://www.google.ca/maps/place/Saint+Louis+University,+Maryheights+Campus/@16.3851708,120.595208,16.04z/data=!4m5!3m4!1s0x0:0x72e90defb83d2bd!8m2!3d16.3842153!4d120.5931548";
            case "University of Malaya":
                return "https://www.google.ca/maps/place/University+of+Malaya/@3.1203518,101.6538051,18.04z/data=!4m5!3m4!1s0x31cdb47024217187:0x1e85ebc65d47d641!8m2!3d3.1201011!4d101.6543993";
            case "Sunway University":
                return "https://www.google.ca/maps/place/Sunway+University/@3.0663299,101.6028088,16.04z/data=!4m5!3m4!1s0x0:0x77612fa0225cad69!8m2!3d3.0671563!4d101.6038902";
            case "University of Tokyo":
                return "https://www.google.ca/maps/place/The+University+of+Tokyo/@35.7124194,139.7616671,19z/data=!4m5!3m4!1s0x60188c2ffa206ea3:0x30e407498313ba95!8m2!3d35.7126775!4d139.761989";
            case "Nihon University":
                return "https://www.google.ca/maps/place/Nihon+University/@35.690953,139.7369171,17z/data=!4m5!3m4!1s0x0:0xc92ee98ac431f2dd!8m2!3d35.6911142!4d139.7374214";
            case "National University of Singapore":
                return "https://www.google.ca/maps/place/National+University+of+Singapore/@1.2965402,103.7759184,19.08z/data=!4m5!3m4!1s0x31da1a56784202d9:0x488d08d6c1f88d6b!8m2!3d1.2966426!4d103.7763939";
            case "Nanyang Technological University":
                return "https://www.google.ca/maps/place/Nanyang+Technological+University/@1.3485926,103.6824543,19.08z/data=!4m5!3m4!1s0x31da0f0a99014463:0xb8bb0800c52d8219!8m2!3d1.3483099!4d103.6831347";
            case "University of Oxford":
                return "https://www.google.ca/maps/place/University+of+Oxford/@51.7548164,-1.2543668,15z/data=!4m5!3m4!1s0x0:0xd2ff1883a001afed!8m2!3d51.7548164!4d-1.2543668";
            case "University of Cambridge":
                return "https://www.google.ca/maps/place/University+of+Cambridge/@52.204523,0.1143935,16z/data=!4m5!3m4!1s0x0:0x21ca80abf36db5bb!8m2!3d52.2042666!4d0.1149085";
            case "Ghent University":
                return "https://www.google.ca/maps/place/Ghent+University/@51.0464691,3.7273935,17.08z/data=!4m5!3m4!1s0x0:0xd7f322018e104783!8m2!3d51.0465619!4d3.7279181";
            case "KU Leuven":
                return "https://www.google.ca/maps/place/Katholieke+Universiteit+Leuven/@50.8778819,4.699804,19.08z/data=!4m5!3m4!1s0x47c160d85ad4f2af:0x2cf72ac3db15442d!8m2!3d50.8779545!4d4.7002953";
            case "University of Zurich":
                return "https://www.google.ca/maps/place/University+of+Zurich/@47.3752739,8.5509383,16z/data=!4m5!3m4!1s0x0:0xba50fa52d07edacf!8m2!3d47.3743221!4d8.5509812";
            case "University of Geneva":
                return "https://www.google.ca/maps/place/University+of+Geneva/@46.1994704,6.1448147,19z/data=!4m8!1m2!2m1!1suniversity+of+geneva!3m4!1s0x478c645147ac22df:0xad225b6b9a989b22!8m2!3d46.199444!4d6.1451157";
            case "Technical University of Munich":
                return "https://www.google.ca/maps/place/Technische+Universit%C3%A4t+M%C3%BCnchen/@48.1496257,11.5677001,19.96z/data=!4m5!3m4!1s0x479e7261336d8c11:0x79a04d44dc5bf19d!8m2!3d48.14966!4d11.5678602";
            case "Humboldt University of Berlin":
                return "https://www.google.ca/maps/place/Humboldt+University+of+Berlin/@52.5177472,13.3930306,18.92z/data=!4m5!3m4!1s0x47a84dd62abc4223:0xa9e4717157f226c5!8m2!3d52.517883!4d13.3936551";
            case "University of Melbourne":
                return "https://www.google.ca/maps/place/University+of+Melbourne/@-37.8013766,144.9653534,13.96z/data=!4m5!3m4!1s0x0:0xeacb63e2b725ff6d!8m2!3d-37.7963689!4d144.9611738";
            case "University of Sydney":
                return "https://www.google.ca/maps/place/The+University+of+Sydney/@-33.8890759,151.1868769,18.34z/data=!4m5!3m4!1s0x0:0x1d017d69037a07c0!8m2!3d-33.888584!4d151.1873473";
            case "University of Auckland":
                return "https://www.google.ca/maps/place/The+University+of+Auckland/@-36.8533923,174.7684936,17.08z/data=!4m5!3m4!1s0x0:0xbd49f61f758a9e5b!8m2!3d-36.8523378!4d174.7691073";
            case "University of Otago":
                return "https://www.google.ca/maps/place/University+of+Otago/@-45.8642913,170.5148733,17z/data=!4m5!3m4!1s0x0:0x761f754c6bfb9a70!8m2!3d-45.8646835!4d170.5144227";
            case "University of Papua New Guinea":
                return "https://www.google.ca/maps/place/University+of+Papua+New+Guinea/@-9.4052604,147.1702712,16.71z/data=!4m5!3m4!1s0x0:0xa62997139cde40c7!8m2!3d-9.4054775!4d147.1703952";
            case "Divide Word University":
                return "https://www.google.ca/maps/place/Divine+Word+University/@-5.2248321,145.7903766,17z/data=!3m1!4b1!4m5!3m4!1s0x68f5e6daddf7403d:0x254517e0ed23cbf2!8m2!3d-5.2248321!4d145.7925653";
            case "University of South Pacific":
                return "https://www.google.ca/maps/place/The+University+of+the+South+Pacific/@-18.1499567,178.4418357,17z/data=!3m1!4b1!4m5!3m4!1s0x6e1bddd1d33b500d:0x151b26830981d6a1!8m2!3d-18.1499567!4d178.4440244";
            case "University of Fiji":
                return "https://www.google.ca/maps/place/The+University+of+Fiji/@-17.6686204,177.407203,18.08z/data=!4m5!3m4!1s0x6e175d6e89584621:0x289c8fca4996febb!8m2!3d-17.6686912!4d177.4080098";
            case "University of Waterloo":
                return "https://www.google.ca/maps/place/University+of+Waterloo/@43.4618828,-80.5387246,13.96z/data=!4m5!3m4!1s0x0:0xdd9df23996268e17!8m2!3d43.4722854!4d-80.5448576";
            case "University of British Columbia":
                return "https://www.google.ca/maps/place/The+University+of+British+Columbia/@49.2647502,-123.2602925,15z/data=!4m8!1m2!2m1!1suniversity+of+british+columbia!3m4!1s0x548672cc2fd41e03:0xc79dd4e7732aa2f3!8m2!3d49.2606052!4d-123.2459938";
            default:
                return "https://www.google.ca/maps/place/University+of+Guelph/@43.5330819,-80.2271556,18.04z/data=!4m5!3m4!1s0x882b9b3c1d38a0b7:0x8feb99e54d4013c7!8m2!3d43.5328929!4d-80.2262444";
        }
    }
}
