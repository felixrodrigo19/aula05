package br.com.ite.si.aula

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.view_form_field.view.*

enum class ErrorType {
    INVALID_ARGS,
    DIVISION_BY_ZERO,
    OUT_OF_MEMORY;

    val canBeHandled get() = when(this) {
        INVALID_ARGS -> true
        DIVISION_BY_ZERO -> true
        OUT_OF_MEMORY -> false
    }

    fun handleError() {
        if (canBeHandled) {
            //... trata erro
        }
    }
}

fun op(): ErrorType? {
    // ...
    return null
}

fun stuff() {
    op()?.run { handleError() }
}

class FormField : FrameLayout {
    constructor(context: Context) : super(context) {
        setup(context, null)
    }
    constructor(context: Context, attrs: AttributeSet?)
            : super(context, attrs) {
        setup(context, attrs)
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        setup(context, attrs)
    }

    private fun setup(context: Context, attrs: AttributeSet?) {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.view_form_field, this)

        label = text_form_field_label
        valueEdit = edit_form_field_value

        attrs?.let {
            val attr = context.obtainStyledAttributes(attrs, R.styleable.FormField)
            priority = attr.getInt(R.styleable.FormField_priority, 1000)
            labelText = attr.getString(R.styleable.FormField_labelText) ?: ""
            hint = attr.getString(R.styleable.FormField_android_hint) ?: ""
            text = attr.getString(R.styleable.FormField_android_text)  ?: ""
            valueEdit.inputType = attr.getInt(
                R.styleable.FormField_android_inputType, 0
            )
            attr.recycle()
        }
    }

    private lateinit var label: TextView
    private lateinit var valueEdit: EditText
    var priority: Int? = null

    var labelText: String
        get() = label.text.toString()
        set(value) {
            label.text = value
        }

    var hint: String
        get() = valueEdit.hint.toString()
        set(value) { valueEdit.hint = value }

    var text: String
        get() = valueEdit.text.toString()
        set(value) = valueEdit.setText(value)

//    init {
//        val inflater = LayoutInflater.from(context)
//        inflater.inflate(R.layout.view_form_field, this)
//
//        label = text_form_field_label
//        valueEdit = edit_form_field_value
//
//    }
}