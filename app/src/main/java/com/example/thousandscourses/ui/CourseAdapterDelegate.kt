package com.example.thousandscourses.ui

import android.annotation.SuppressLint
import com.example.thousandscourses.R
import com.example.thousandscourses.databinding.ItemCourseBinding
import com.example.thousandscourses.domain.model.Course
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

@SuppressLint("SetTextI18n")
fun courseAdapterDelegate(onFavoriteClick: (Course) -> Unit) =
    adapterDelegateViewBinding<Course, Course, ItemCourseBinding>(
        { layoutInflater, root -> ItemCourseBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            binding.titleTextView.text = item.title
            binding.descriptionTextView.text = item.text
            binding.priceTextView.text = "${item.price} P"
            binding.ratingTextView.text = item.rate
            binding.participateTextView.text = item.startDate
            binding.favoriteButton.setImageResource(
                if (item.hasLike) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_border
            )
        }
        binding.favoriteButton.setOnClickListener {
            onFavoriteClick(item)
        }
    }