package com.example.calculadora

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadora.databinding.ActivityMainBinding

//para activar el binding  se agrega binding
class MainActivityBinding : AppCompatActivity() { // inicio de clase
    // crea la clase porque ya lo pedimos cuando agregamos binding. se agrega lateinit que es inicializacion tardia
    // solo crea la variable no le asigna un tipo de dato solo reserva el espacio
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            ActivityMainBinding.inflate(layoutInflater) // se ocupa la variable y la inicialiaza  y se agrega un metodo inflater
        val view = binding.root  // binding.root  root es decir tomar todos los botones

        enableEdgeToEdge()
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var resultado =
            0.0 //creo una nueva varible de nombre resultado y le asigno el valor de entrada 0.0
        //creo cuatro banderas la operacion principal de idea que en cuando se seleccione prenda
        var suma = false  // bandera de suma inicializada como apagada
        var resta = false
        var multiplicacion = false
        var division = false

        binding.ceroButton.setOnClickListener {  //cuando le den click va a mostrar al tex view

            binding.salidaTextview.text = Contador(0)

        }

        binding.unoButton.setOnClickListener {  //cuando le den click va a mostrar al tex view

            binding.salidaTextview.text = Contador(1)

        }
        binding.dosButton.setOnClickListener {  //cuando le den click va a mostrar al tex view

            binding.salidaTextview.text = Contador(2)

        }
        binding.tresButton.setOnClickListener {  //cuando le den click va a mostrar al tex view

            binding.salidaTextview.text = Contador(3)

        }

        binding.cuatroButton.setOnClickListener {  //cuando le den click va a mostrar al tex view

            binding.salidaTextview.text = Contador(4)

        }

        binding.cincoButton.setOnClickListener {  //cuando le den click va a mostrar al tex view

            binding.salidaTextview.text = Contador(5)

        }

        binding.seisButton.setOnClickListener {  //cuando le den click va a mostrar al tex view

            binding.salidaTextview.text = Contador(6)

        }

        binding.sieteButton.setOnClickListener {  //cuando le den click va a mostrar al tex view

            binding.salidaTextview.text = Contador(7)

        }

        binding.ochoButton.setOnClickListener {  //cuando le den click va a mostrar al tex view

            binding.salidaTextview.text = Contador(8)

        }

        binding.nueveButton.setOnClickListener {  //cuando le den click va a mostrar al tex view

            binding.salidaTextview.text = Contador(9)

        }

        binding.acButton.setOnClickListener {
            binding.salidaTextview.text = "0"
        }

        binding.puntoButton.setOnClickListener {
            if (!binding.salidaTextview.text.contains("."))
                binding.salidaTextview.text = "${binding.salidaTextview.text}."


        }

        binding.masmenosButton.setOnClickListener {
            binding.salidaTextview.text =
                (binding.salidaTextview.text.toString().toDouble() * -1).toString()
        }

        binding.porcientoButton.setOnClickListener {
            binding.salidaTextview.text = (binding.salidaTextview.text.toString().toFloat() / 100).toString()

        }

        //operaciones


        //suma
        binding.masButton.setOnClickListener {
            resultado = binding.salidaTextview.text.toString().toDouble()
            binding.salidaTextview.text = "0"
            suma = true
            resta = false
            multiplicacion = false
            division = false
        }
        //menos
        binding.menosButton.setOnClickListener {
            resultado = binding.salidaTextview.text.toString().toDouble()
            binding.salidaTextview.text = "0"
            suma = false
            resta = true
            multiplicacion = false
            division = false
        }
//multi
        binding.porButton.setOnClickListener {
            resultado = binding.salidaTextview.text.toString().toDouble()
            binding.salidaTextview.text = "0"
            suma = false
            resta = false
            multiplicacion = true
            division = false
        }
// divicion
        binding.masButton.setOnClickListener {
            resultado = binding.salidaTextview.text.toString().toDouble()
            binding.salidaTextview.text = "0"
            suma = false
            resta = false
            multiplicacion = false
            division = true
        }

        binding.igualButton.setOnClickListener {
            when {
                suma -> {
                    resultado = resultado + binding.salidaTextview.text.toString().toDouble()
                    //resultado +=  binding.salidaTextview.text.toString().toDouble()
                    binding.salidaTextview.text = resultado.toString()
                    //binding.salidaTextview.text= "$resultado"
                    suma = false
                    binding.masButton.visibility= View.VISIBLE
                }


                resta -> {
                    resultado = resultado - binding.salidaTextview.text.toString().toDouble()
                    //resultado +=  binding.salidaTextview.text.toString().toDouble()
                    binding.salidaTextview.text = resultado.toString()
                    //binding.salidaTextview.text= "$resultado"
                    resta = false
                    binding.menosButton.visibility= View.VISIBLE
                }

                multiplicacion -> {
                    resultado = resultado * binding.salidaTextview.text.toString().toDouble()
                    //resultado +=  binding.salidaTextview.text.toString().toDouble()
                    binding.salidaTextview.text = resultado.toString()
                    //binding.salidaTextview.text= "$resultado"
                    multiplicacion = false
                    binding.porButton.visibility= View.VISIBLE
                }

                division -> {
                    resultado = resultado / binding.salidaTextview.text.toString().toDouble()
                    //resultado +=  binding.salidaTextview.text.toString().toDouble()
                    binding.salidaTextview.text = resultado.toString()
                    //binding.salidaTextview.text= "$resultado"
                    division = false
                    binding.entreButton.visibility= View.VISIBLE
                }
            }
        }




     //   R.id.cero_button. // se le va agregar un listener
    // R es la base de datos de todos lo elementos


    } // fin funcion onCreate

    //creo una nueva funcion  : para aguardar numero y poner el otro y concatenar
    fun Contador (nuevoNumero: Int): String {
           // binding.salidaTextview.text="$textoActual$nuevoNumero"
         //binding.salidaTextview.text=textoActual.toString().plus(nuevoNumero.toString())
           // binding.salidaTextview.text="${binding.salidaTextview.text}$nuevoNumero"
       if(binding.salidaTextview.text=="0"){
           return "$nuevoNumero"
       }
           else{
               return "${binding.salidaTextview.text}$nuevoNumero"
           }


        //return "${binding.salidaTextview.text}$nuevoNumero"
    }

} // fin de la clase  mainActivity

//  comentario
/*
comentario
multilinea
 */

