# Security

** Steps **
- system inventory and backup

## Lock the user account

sudo passwd -l "$USERNAME"
sudo chage -M 90 "$USERNAME" # Maximum days before a password change
sudo chage -m 7 "$USERNAME"   # Minimum days before a password change
sudo chage -I 30 "$USERNAME"   # Inactive days after password expiry
sudo chage -d 0 "$USERNAME"    # Forces password change on next login

# guessing_game_java
