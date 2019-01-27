# RecyclerViewAnimations
RecyclerViewAnimations is a helper project for the blog [RecyclerView — time to animate! (with payloads and DiffUtil)](https://medium.com/p/recyclerview-time-to-animate-with-payloads-and-diffutil-4278beb8d4dd).

It is a showcase for the RecyclerView.Adapter notify methods, payloads functionality and DiffUtil tool.

These tools are used to initiate DefaultItemAnimator animations. DefaultItemAnimator animates item removal by fading it out, insertion by fading it in, movement by translating it and change by cross-fading the old view instance with the new one.

**Travelino** theme design is provided by [Siniša Cvahte](https://dribbble.com/pixilated).

<img src="assets/app_image.png" width="20%">

## Animation examples
| Insert | Move | Remove range |
| --- | --- | --- |
|![](assets/notify_insert_demo.gif)|![](assets/notify_move_demo.gif)|![](assets/notify_remove_range_demo.gif)|

| Change | Change with Payload | DiffUtil |
| --- | --- | --- |
|![](assets/notify_change_demo.gif)|![](assets/notify_change_with_payload_demo.gif)|![](assets/diff_util_demo.gif)|

## License

```
MIT License

Copyright (c) 2019 Ivan Martinovic

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```