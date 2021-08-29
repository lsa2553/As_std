package com.example.myapplicationdasdasd

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationdasdasd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this

//        binding.check.isChecked = true
//        binding.check.setOnCheckedChangeListener { buttonView, isChecked ->
//            binding.check.text = if (isChecked) "check" else "no check"
//        }
//
//
//        binding.but.setOnClickListener {
//            Log.d(TAG, "버튼클릭")
//            Toast.makeText(this, "배고프다", Toast.LENGTH_SHORT).show()
//
//        }
//
//        binding.face.setImageResource(R.drawable.face)
//        binding.rg.checkedRadioButtonId
//        binding.rg.setOnCheckedChangeListener { group, checkedId ->
//            when(checkedId){
//                R.id.ah -> {
//                    Toast.makeText(this, "아,,,,,,", Toast.LENGTH_SHORT).show()
//                    binding.face.setImageResource(R.drawable.face)
//                    binding.progress.progress = 2
//                }
//                R.id.hoo -> {
//                    Toast.makeText(this, "후,,,,,,", Toast.LENGTH_SHORT).show()
//                    binding.face.setImageResource(R.drawable.ic_share)
//                    binding.progress.progress = 8
//                }
//            }
//
//
//        }
//
//        val items = arrayListOf("hello", "world", "!!!")
//        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
//
//        binding.spinner.adapter = adapter
//        binding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                when(position){
//                    0 -> Log.d(TAG, "안녕!")
//                    1 -> Log.d(TAG,"세상아!!")
//                    2 -> Log.d(TAG,"내가왔다!!!!")
//                }
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                TODO("Not yet implemented")
//            }
//        }
//
//        binding.sb.setOnSeekBarChangeListener(object :
//        SeekBar.OnSeekBarChangeListener{
//            override fun onStartTrackingTouch(seekBar: SeekBar?) {
////                TODO("Not yet implemented")
//            }
//
//            override fun onStopTrackingTouch(seekBar: SeekBar?) {
////                TODO("Not yet implemented")
//            }
//
//            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//                Log.d(TAG, "현재 값은 ${progress}")
//            }
//        })
//
//        binding.progress.max = 10
//        binding.progress.progress = 4
//
//        binding.et.editText?.text.toString()
//        binding.et.editText?.addTextChangedListener(object: TextWatcher{
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//
//                if(s.toString().length<6){
//                    binding.et.error="6자 이상 입력하세요"
//                }
//                else{
//                    binding.et.error=null
//                }
//            }
//        })



        var b: Int

//        var man = 10
//        var woman = 10
//
//        if(man>woman){
//            Log.d(TAG,"남초")
//        }
//        else if (man<woman){
//            Log.d(TAG,"여초")
//        }
//        else
//            Log.d(TAG,"성비 1:1")
//        for(i in 2..10 step 2){
//            Log.d(TAG,"멍청이 ${i}명")
//        }
//        var List = arrayListOf(100, 68, 80, 52, 60, 55, 96, 92, 89, 69)
//        var add = 0
//        var s = 0.0f
//        var max = 0
//        var min = 100
//        for (i in List){
//            add+=i
//            if(max<i){
//                max = i
//            }
//            if(min>i){
//                min = i
//            }
//        }
//        s = add/List.size.toFloat()
//        Log.d(TAG,"평균 ${s}, 최대 ${max}, 최소 ${min}")
//        val animal = Animal(4,"여자", "먼지")
//        animal.eat("사료")
//        val animal2 = Animal(17,"여자", "수아")
//        animal2.eat("아메리카노")
//
//        val person = Person(4, "여자", "이수아", "050503", "대한민국")
//        person.eat("마라탕")
//        person.soom()

//        val d = ContextCompat.getDrawable(this, R.drawable.ic_share)
//        val color = ContextCompat.getColor(this, R.color.teal_200)
//        binding.imageView.l

//        val list = arrayListOf("item 01", "item 02", "item 03")
//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
//        binding.list.adapter = adapter
//
//
//        binding.list.setOnItemClickListener { parent, view, position, id ->
//            Toast.makeText(this, "$position : ${list[position]}", Toast.LENGTH_SHORT).show()
//        }

//        binding.bton.setOnClickListener{
//            adapter.add("item")
////            Log.d(TAG,"${list.size}")
//            adapter.notifyDataSetChanged()
//        }

        val list = arrayListOf(
            Lab("안녕",System.currentTimeMillis(),true ),
            Lab("잘가",System.currentTimeMillis(),true )
        )
        val adapter = CoolAdapter(list)
        binding.list.layoutManager = LinearLayoutManager(this)
        binding.list.adapter = adapter
//
//        binding.bton.setOnClickListener{
//            adapter.addItem(animal = Animal(14, "여자", "이유빈"))


        val cI = "hangul_no"
        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            nm.createNotificationChannel(NotificationChannel(cI, getString(R.string.ziho),NotificationManager.IMPORTANCE_DEFAULT))
        }
        val noti = NotificationCompat.Builder(this, cI).apply {
            setContentTitle("ddd")
            setContentText("집가고싶다!")
            color = ContextCompat.getColor(applicationContext,R.color.teal_700)
            setSmallIcon(R.drawable.ic_share)
        }
        nm.notify(100, noti.build())


        LocalBroadcastManager.getInstance(this).registerReceiver(object: BroadcastReceiver(){
            override fun onReceive(context: Context, intent: Intent) {
                val name = intent.getStringExtra("name")
                val age = intent.getIntExtra("age", 100)
                Log.d(TAG,"${name},$age")
            }
        }, IntentFilter("aaaaa"))

        val actionIntent = Intent("aaaaa").apply {
            putExtra("name", "이수아")
            putExtra("age",17)
        }


        binding.bton.setOnClickListener {
            LocalBroadcastManager.getInstance(this).sendBroadcast(actionIntent)
        }

    }

}

