Activity Split Animation
========================

A utility class to create split Activity animation.

![screenshots](https://raw.github.com/Udinic/ActivitySplitAnimation/master/screenshots/all.png)

Usage
=====

On Activity A, when you want to call Activity B, use:

	ActivitySplitAnimationUtil.startActivity(Activity1.this, new Intent(Activity1.this, Activity2.class));

On Activity B's onCreate():

	ActivitySplitAnimationUtil.prepareAnimation(this);

	// Setting the Activity's layout
	setContentView(R.layout.act_two);

	// Animation duration of 1 second
	ActivitySplitAnimationUtil.animate(this, 1000);


Developed By
============

* Udi Cohen (udinic@gmail.com)



License
=======

Copyright 2013 Udi Cohen

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

 [1]: 	https://raw.github.com/Udinic/ActivitySplitAnimation/master/screenshots/screenshot1.png
