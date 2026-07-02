# ForceGL3.0-Remapped

OpenGL 3.0 compatibility for Minecraft 26.1.2 and 26.2

> A remapped and updated version of [ForceGL3.0](https://github.com/coredex-source/ForceGL3.0).

- Supports **Minecraft 26.1.2** and **26.2**.
- Designed for **Fabric**.
- Allows Minecraft to run on **OpenGL 3.0** hardware.
- Original project by **coredex-source**.

> **Note**
>
> At the moment, only the **Minecraft 26.2** build is available.
> The **26.1.2** build will be published in the next few days.

---

## Screenshots

### Main Menu

![Main Menu](images/main_menu.png)

### In-game

![Gameplay](images/gameplay.png)

### Hardware Information

![F3](images/f3.png)

---

## It doesn't work!

Before opening an issue, make sure Minecraft is failing because your graphics driver does **not support OpenGL 3.2/3.3**, even though it supports **OpenGL 3.0**.

ForceGL3.0-Remapped is designed **only** for this compatibility issue.

It does **not** fix missing graphics drivers, corrupted driver installations, or other unrelated GLFW/OpenGL errors.

---

## Recommended Settings

> **Warning**
>
> Older OpenGL 3.0 GPUs may experience rendering issues or crashes with high graphics settings.

For the best compatibility, it is recommended to:

- Set **Graphics** to **Fast**.
- Disable **Clouds**.
- Disable **Entity Shadows**.
- Use the **minimum Render Distance** your hardware can comfortably handle.
- Disable any resource packs or shaders.
- Keep graphics settings as low as possible.

These settings greatly improve stability on older Intel HD Graphics and similar GPUs.

---

## What's New?

Compared to the original ForceGL3.0:

- ✅ Ported to Minecraft **26.1.2**
- ✅ Ported to Minecraft **26.2**
- ✅ Updated to Mojang's new rendering backend
- ✅ Updated Mixins
- ✅ Added OpenGL compatibility fixes
- ✅ Improved compatibility with Intel HD Graphics

---

## Fixes

- Fixes game not launching on OpenGL 3.0 GPUs.
- Fixes several rendering calls introduced in Minecraft 26.x.
- Allows modern Minecraft to run on legacy GPUs that only support OpenGL 3.0.

---

## Why?

Since Minecraft 1.17, Mojang requires **OpenGL 3.2**.

Older GPUs such as:

- Intel HD Graphics 3000
- Intel HD Graphics 2000
- Older AMD GPUs
- Older NVIDIA GPUs

only support **OpenGL 3.0**, preventing Minecraft from starting.

ForceGL3.0-Remapped restores compatibility by forcing an OpenGL 3.0 context and adapting modern rendering calls.

---

## Tested Hardware

| GPU | OpenGL | Minecraft | Status |
|------|---------|-----------|--------|
| Intel HD Graphics 3000 | 3.0 | 26.2 | ✅ Working |

---

## Supported Versions

| Minecraft | Status |
|------------|--------|
| 26.1.2 | ✅ (Coming soon) |
| 26.2 | ✅ Available |
| Newer snapshots | ⚠️ Not guaranteed |

---

## But does it work?

Yes.

This mod has been successfully tested on real OpenGL 3.0 hardware.

However, Minecraft officially requires OpenGL 3.2, so some future Minecraft versions, snapshots, mods or resource packs may not work correctly.

---

## Bug Reports

Found a bug?

Please open an issue on GitHub and include:

- Your Minecraft version.
- Your GPU model.
- Your operating system.
- The complete **latest.log** or crash report.

Bug reports **without logs** are very difficult to investigate.

---

## Credits

Original project:

https://github.com/coredex-source/ForceGL3.0

This project is a fork/remap of ForceGL3.0 updated for Minecraft 26.1.2 and 26.2.

Additional work includes:

- Port to Minecraft 26.1.2
- Port to Minecraft 26.2
- Updated rendering compatibility
- Updated Mixins
- OpenGL 3.0 compatibility improvements

All credit for the original implementation goes to **coredex-source**.

---

## Compiling

```bash
./gradlew build
```

The compiled mod will be located in:

```
build/libs/
```

---

## Have an older graphics card?

If your GPU only supports **OpenGL 2.0**, use the original **ForceGL2.0** project instead:

https://github.com/coredex-source/ForceGL2.0-1.2x

---

## License

This project is licensed under the **MIT License**.

See the LICENSE file for details.
