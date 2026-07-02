# ForceGL3.0-Remapped
OpenGL 3.0 compatibility for Minecraft 26.1.2 and 26.2

> A remapped and updated version of [ForceGL3.0](https://github.com/coredex-source/ForceGL3.0).

- Supports **Minecraft 26.1.2** and **26.2**.
- Designed for **Fabric**.
- Allows Minecraft to run on **OpenGL 3.0** hardware.
- Original project by **coredex-source**.

---

## Screenshots

### Main Menu

![Main Menu](images/main_menu.png)

### In-game

![Gameplay](images/gameplay.png)

### Hardware Information

![F3](images/f3.png)

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

ForceGL3.0 Remapped restores compatibility by forcing a 3.0 context and adapting modern rendering calls.

---

## Tested Hardware

| GPU | OpenGL | Minecraft | Status |
|------|---------|-----------|--------|
| Intel HD Graphics 3000 | 3.0 | 26.2 | ✅ Working |

---

## Supported Versions

| Minecraft | Status |
|------------|--------|
| 26.1.2 | ✅ |
| 26.2 | ✅ |
| Newer snapshots | ⚠️ Not guaranteed |

---

## But does it work?

Yes.

This mod has been successfully tested on real OpenGL 3.0 hardware.

However, Minecraft officially requires OpenGL 3.2, so some future versions or mods may not work correctly.

---

## Credits

Original project:

https://github.com/coredex-source/ForceGL3.0

This project is a fork/remap of ForceGL3.0 updated for Minecraft 26.1.2 and 26.2.

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

## License

See the original project's license.
